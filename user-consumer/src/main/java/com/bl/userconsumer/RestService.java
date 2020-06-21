package com.bl.userconsumer;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.xml.transform.Templates;

/**
 * @Deacription TODO
 * @Author BarryLee
 * @Date 2020/6/21 21:00
 */
@Service
public class RestService {

  @Autowired
  private RestTemplate restTemplate;

  @HystrixCommand(defaultFallback = "back")
  public String alive() {
    System.out.println("rest serice alive2");
    String url = "http://user-provider/alive2";
    return restTemplate.getForObject(url, String.class);
  }

  String back() {
    System.out.println("back .. ");
    return "呵呵";
  }

}
