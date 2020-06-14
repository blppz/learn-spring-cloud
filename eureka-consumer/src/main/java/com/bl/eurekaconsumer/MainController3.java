package com.bl.eurekaconsumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Deacription TODO
 * @Author BarryLee
 * @Date 2020/6/14 10:04
 */
@RestController
public class MainController3 {

  @Autowired
  RestTemplate restTemplate;

  /**
   * 自动处理URL，不用手动拼接,需要LoadBalanced注解加在restTemplate上
   * @return
   */
  @GetMapping("/client10")
  public Object client10() {
    // http://服务主机名/资源名
    String url = "http://provider/getHi";
    final String res = restTemplate.getForObject(url, String.class);
    final ResponseEntity<String> entity = restTemplate.getForEntity(url, String.class);
    // hi，port==82
    System.out.println(res);
    System.out.println("----");
    // 状态码，body，头
    // <200,hi，port==82,[Content-Type:"text/plain;charset=UTF-8", Content-Length:"13", Date:"Sun, 14 Jun 2020 15:06:46 GMT", Keep-Alive:"timeout=60", Connection:"keep-alive"]>
    System.out.println(entity);
    return res;
  }

  /**
   * 测试restTemplate获取一个map
   */
  @GetMapping("/client11")
  public Object client11() {
    String url = "http://provider/getMap";
    final Map map = restTemplate.getForObject(url, Map.class);
    System.out.println(map);
    return map;
  }

  /**
   * 测试restTemplate获取一个person对象
   */
  @GetMapping("/client12")
  public Object client12() {
    String url = "http://provider/getPerson";
    final Person person = restTemplate.getForObject(url, Person.class);
    System.out.println(person);
    return person;
  }

  /**
   * 测试restTemplate获取一个person对象，并且传递参数
   */
  @GetMapping("/client13")
  public Object client13() {
    String url = "http://provider/getPerson2?name={name}";
    final Person person = restTemplate.getForObject(url, Person.class, "BarryLee");
    System.out.println(person);
    return person;
  }

  /**
   * 测试restTemplate get请求传递一个map
   */
  @GetMapping("/client14")
  public Object client14() {
    String url = "http://provider/getPerson2?name={name}";
    final Map<String, String> map = Collections.singletonMap("name", "xixi");
    final Person person = restTemplate.getForObject(url, Person.class, map);
    System.out.println(person);
    return person;
  }

  /**
   * 测试restTemplate post请求传递一个map
   */
  @GetMapping("/client15")
  public Object client15() {
    String url = "http://provider/updatePerson";
    final Map<String, String> map = Collections.singletonMap("name", "xixi");
    final ResponseEntity<Person> res = restTemplate.postForEntity(url, map, Person.class);
    System.out.println(res);
    return res;
  }

}