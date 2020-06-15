package com.bl.eurekaconsumer;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class EurekaConsumerApplication {

  public static void main(String[] args) {
    SpringApplication.run(EurekaConsumerApplication.class, args);
  }

  /**
   * RestTemplate无状态，每个线程玩自己的，不必每次使用new一个，用单例就可以
   * client9不再手动拼接URL，需要LoadBalanced注解，client1-8都不用
   */
  /*@Bean
  @LoadBalanced
  public RestTemplate getRestTemplate() {
    return new RestTemplate();
  }*/
  @Bean
  @LoadBalanced
  public RestTemplate getRestTemplate() {
    RestTemplate restTemplate = new RestTemplate();
    // 加上拦截器，可以加多个
    restTemplate.getInterceptors().add(new LogginClientHttpRequestInteceptor());
    return restTemplate;
  }

  /**
   * 切换负载算法
   */
  // @Bean
  public IRule myRule() {
    // 随机算法负载均衡
    return new RandomRule();
    // 自定义负载算法
    //return new MyRule();
  }

}
