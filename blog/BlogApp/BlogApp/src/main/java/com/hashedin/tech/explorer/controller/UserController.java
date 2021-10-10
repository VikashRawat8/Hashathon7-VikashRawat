package com.hashedin.tech.explorer.controller;

import com.hashedin.tech.explorer.model.UserDto;
import com.hashedin.tech.explorer.service.IUserService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserController {

  IUserService userService;

  @GetMapping("/{userId}")
  public ResponseEntity<UserDto> getUser(@PathVariable Long userId) {
    return ResponseEntity.ok(userService.getUser(userId));
  }

  @PostMapping
  public ResponseEntity<UserDto> createUser(@RequestBody UserDto request) {
    return ResponseEntity.ok(userService.createUser(request));
  }
}
