package com.hashedin.tech.explorer.entity;

import java.util.Objects;
import java.util.Set;
import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.Transient;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@AttributeOverride(name = "id", column = @Column(name = "tag_id"))
public class Tag extends BaseEntity {

  String name;

  String defaultIcon;

  String backgroundImage;

  String externalDocs;

  @ManyToOne
  User addedBy;

  @Transient
  @ManyToMany(mappedBy = "tags", fetch = FetchType.LAZY)
  transient Set<Post> relatedPosts;

  @Override
  public boolean equals(Object o) {
    if (this == o) {return true;}
    if (o == null || getClass() != o.getClass()) {return false;}
    if (!super.equals(o)) {return false;}
    Tag tag = (Tag) o;
    return name.equals(tag.name) &&
        Objects.equals(defaultIcon, tag.defaultIcon) &&
        Objects.equals(backgroundImage, tag.backgroundImage) &&
        Objects.equals(externalDocs, tag.externalDocs) &&
        Objects.equals(addedBy, tag.addedBy);
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), name, defaultIcon, backgroundImage, externalDocs, addedBy);
  }
}
