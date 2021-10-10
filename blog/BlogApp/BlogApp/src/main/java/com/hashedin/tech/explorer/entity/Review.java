package com.hashedin.tech.explorer.entity;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
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
@AttributeOverride(name = "id", column = @Column(name = "review_id"))
public class Review extends BaseEntity implements Serializable {

  @ManyToOne(optional = false)
  User reviewer;

  @Column(columnDefinition = "boolean default false")
  Boolean isSuccess;

  @OneToOne
  Comment relatedComment;

  @Override
  public boolean equals(Object o) {
      if (this == o) {return true;}
      if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) {return false;}
    Review review = (Review) o;
    return Objects.equals(getId(), review.getId());
  }

  @Override
  public int hashCode() {
    return 0;
  }
}
