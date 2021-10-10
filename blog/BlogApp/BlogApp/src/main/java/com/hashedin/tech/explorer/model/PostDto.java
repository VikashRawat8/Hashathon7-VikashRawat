package com.hashedin.tech.explorer.model;

import com.hashedin.tech.explorer.entity.User;
import java.time.LocalDateTime;
import java.util.Set;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PostDto {

  String title;

  String content;

  UserDto author;

  Long id;

  Long version;

  LocalDateTime createdAt;

  LocalDateTime lastModifiedAt;

  Set<String> tagNames;

}
