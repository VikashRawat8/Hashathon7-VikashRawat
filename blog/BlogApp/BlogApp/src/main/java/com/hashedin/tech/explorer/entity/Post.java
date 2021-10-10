package com.hashedin.tech.explorer.entity;

import java.io.Serializable;
import java.util.Objects;
import java.util.Set;
import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;
import org.hibernate.Hibernate;
import org.springframework.data.annotation.Transient;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity(name = "blog_post")
@FieldDefaults(level = AccessLevel.PRIVATE)
@AttributeOverride(name = "id", column = @Column(name = "post_id"))
public class Post extends BaseEntity implements Serializable {

  @Column(nullable = false, length = 1026)
  String title;

  @Column(columnDefinition = "TEXT", nullable = false)
  String content;

  @ManyToOne(optional = false, fetch = FetchType.EAGER)
  User author;

  @Transient
  @ManyToMany(fetch = FetchType.EAGER)
  @JoinTable(
      name = "tag_for_post",
      joinColumns = @JoinColumn(name = "tag_id"),
      inverseJoinColumns = @JoinColumn(name = "post_id")
  )
  Set<Tag> tags;

  @Override
  public boolean equals(Object o) {
    if (this == o) {return true;}
    if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) {return false;}
    Post post = (Post) o;
    return Objects.equals(getId(), post.getId());
  }

  @Override
  public int hashCode() {
    return 0;
  }
}
