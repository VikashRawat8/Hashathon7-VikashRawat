package com.hashedin.tech.explorer.service;

import com.hashedin.tech.explorer.model.UserDto;

public interface IUserService {

  UserDto getUser(Long userId);

  UserDto createUser(UserDto request);
}
