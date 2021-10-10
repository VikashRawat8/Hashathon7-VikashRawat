package com.hashedin.tech.explorer.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ConversionUtil {

  ObjectMapper objectMapper;

  public <P, R> R convert(P source, Class<R> classType) {
    return objectMapper.convertValue(source, classType);
  }
}
