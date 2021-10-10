package com.hashedin.tech.explorer.model;

import java.time.LocalDateTime;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserDto {

  String name;

  Long id;

  Long version;

  LocalDateTime createdAt;

  LocalDateTime lastModifiedAt;
}
