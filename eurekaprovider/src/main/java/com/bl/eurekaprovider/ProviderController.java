package com.bl.eurekaprovider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.net.URI;
import java.util.Collections;
import java.util.Map;

/**
 * @Deacription TODO
 * @Author BarryLee
 * @Date 2020/6/8 21:47
 */
@RestController
public class ProviderController {

  /**
   * 注入端口，用来区分不同服务
   */
  @Value("${server.port}")
  private int port;

  @GetMapping("/getHi")
  public String getHi() {
    System.out.println("hi");
    return "hi，port==" + port;
  }

  @Autowired
  private HealthStatusService healthStatusService;

  /**
   * 用来改变当前服务的状态，测试用
   */
  @GetMapping("/health")
  public String health(@RequestParam("status") Boolean status) {
    // 改变状态
    healthStatusService.setStatus(status);
    // 返回当前状态
    return healthStatusService.getStatus();
  }

  /**
   * 用来测试restTemplate接收Map结果
   */
  @GetMapping("/getMap")
  public Map<String, String> getMap() {
    return Collections.singletonMap("id", "123");
  }

  /**
   * 用来测试restTemplate接收Person对象结果
   */
  @GetMapping("/getPerson")
  public Person getPerson() {
    Person person = new Person();
    person.setId(1);
    person.setName("barry lee");
    return person;
  }

  /**
   * 用来测试restTemplate接收Person对象结果，并且接收参数
   */
  @GetMapping("/getPerson2")
  public Person getPerson2(String name) {
    Person person = new Person();
    person.setId(1);
    person.setName(name);
    return person;
  }

  /**
   * 测试restTemplate post请求接收对象
   */
  @PostMapping("/updatePerson")
  public Person updatePerson(@RequestBody Person person) {
    return person;
  }

  /**
   * 用于测试postForLocation
   */
  @PostMapping("/postUri")
  public URI postParam(@RequestBody Person person, HttpServletResponse response) throws Exception {
    URI uri = new URI("https://www.baidu.com/s?wd=" + person.getName());
    response.addHeader("Location", uri.toString());
    return uri;
  }
}
