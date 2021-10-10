package com.hashedin.tech.explorer.service.impl;

import com.hashedin.tech.explorer.entity.User;
import com.hashedin.tech.explorer.model.UserDto;
import com.hashedin.tech.explorer.repository.UserRepository;
import com.hashedin.tech.explorer.service.IUserService;
import java.util.Optional;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserService implements IUserService {

  UserRepository userRepository;

  ConversionUtil conversionUtil;

  @Override
  public UserDto getUser(Long userId) {
    if (ObjectUtils.isEmpty(userId)) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "User Id is required");
    }

    final Optional<User> user = userRepository.findById(userId);

    if (user.isPresent()) {return conversionUtil.convert(user.get(), UserDto.class);}

    throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "User with provided id doesn't exist");
  }

  @Override
  public UserDto createUser(UserDto request) {
    if (ObjectUtils.isEmpty(request)) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "User request is empty");
    }

    User user = conversionUtil.convert(request, User.class);

    user = userRepository.save(user);

    return conversionUtil.convert(user, UserDto.class);
  }

}
