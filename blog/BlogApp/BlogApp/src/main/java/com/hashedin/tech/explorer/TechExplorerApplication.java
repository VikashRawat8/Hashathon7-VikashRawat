package com.hashedin.tech.explorer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
@EnableJpaAuditing
public class TechExplorerApplication {

  public static void main(String[] args) {
    SpringApplication.run(TechExplorerApplication.class, args);
  }

}
