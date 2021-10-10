package com.hashedin.tech.explorer.entity;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;
import org.hibernate.Hibernate;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@AttributeOverride(name = "id", column = @Column(name = "comment_id"))
public class Comment extends BaseEntity implements Serializable {

  @Column(columnDefinition = "TEXT")
  String content;

  @ManyToOne
  User author;

  @ManyToOne
  Post commentedOn;

  @Column(columnDefinition = "boolean default true", nullable = false)
  Boolean isPublic;

  @Column(columnDefinition = "boolean default false", nullable = false)
  Boolean isAnonymous;

  @Override
  public boolean equals(Object o) {
      if (this == o) {return true;}
      if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) {return false;}
    Comment comment = (Comment) o;
    return Objects.equals(getId(), comment.getId());
  }

  @Override
  public int hashCode() {
    return 0;
  }
}
