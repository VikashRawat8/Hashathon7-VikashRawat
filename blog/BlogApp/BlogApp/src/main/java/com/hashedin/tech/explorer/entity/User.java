package com.hashedin.tech.explorer.entity;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
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
@Table(name = "org_user")
@FieldDefaults(level = AccessLevel.PRIVATE)
@AttributeOverride(name = "id", column = @Column(name = "user_id"))
public class User extends BaseEntity implements Serializable {

  @Column(nullable = false)
  String name;

  @Override
  public boolean equals(Object o) {
    if (this == o) {return true;}
    if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) {return false;}
    User user = (User) o;
    return Objects.equals(getId(), user.getId());
  }

  @Override
  public int hashCode() {
    return 0;
  }
}
