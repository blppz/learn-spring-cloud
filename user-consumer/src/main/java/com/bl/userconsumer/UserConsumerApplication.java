package com.bl.userconsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableFeignClients
// 如果是RestTemplate，要加上这个注解才能用Hystrix
@EnableCircuitBreaker
@EnableHystrixDashboard
public class UserConsumerApplication {

  public static void main(String[] args) {
    SpringApplication.run(UserConsumerApplication.class, args);
  }

  @Bean
  @LoadBalanced
  RestTemplate getRestTemplate() {
    RestTemplate restTemplate = new RestTemplate();
    return restTemplate;
  }

}
