package com.bl.user.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;

@SpringBootApplication
public class UserProvicerApplication {

  public static void main(String[] args) {
    SpringApplication.run(UserProvicerApplication.class, args);
  }

}
