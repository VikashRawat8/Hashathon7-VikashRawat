package com.hashedin.tech.explorer.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CommentAssociation implements Serializable {

  @Id
  @OneToOne
  Comment commentedOn;

  @ManyToOne(optional = false)
  Comment immediateParent;

  @ManyToOne(optional = false)
  Comment superParent;

}
