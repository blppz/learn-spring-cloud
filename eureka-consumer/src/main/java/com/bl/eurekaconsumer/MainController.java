package com.bl.eurekaconsumer;

import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.converters.Auto;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @Deacription TODO
 * @Author BarryLee
 * @Date 2020/6/8 22:34
 */
@RestController
public class MainController {

  /**
   * 注意，是spring cloud 抽象的接口
   */
  @Autowired
  DiscoveryClient client;
  //@Autowired
  //EurekaClient client2;

  @Autowired
  LoadBalancerClient lb;

  @GetMapping("/client")
  public String client() {
    final List<String> services = client.getServices();
    System.out.println(services);
    return "client";
  }

  @GetMapping("/client2")
  public List<ServiceInstance> client2() {
    return client.getInstances("provider");
  }

  @GetMapping("/client3")
  public List<ServiceInstance> client3() {
    final List<ServiceInstance> instances = client.getInstances("provider");
    for (ServiceInstance instance : instances) {
      System.out.println(ToStringBuilder.reflectionToString(instance));
    }
    return instances;
  }

  @GetMapping("/client4")
  public List<ServiceInstance> client4() {
    final List<ServiceInstance> instances = client.getInstances("provider");
    if (instances.size() > 0) {
      final ServiceInstance info = instances.get(0);
      String url = "http://" + info.getHost() + ":" + info.getPort() + "/getHi";
      System.out.println(url);
      final RestTemplate restTemplate = new RestTemplate();
      final String res = restTemplate.getForObject(url, String.class);
      System.out.println(res);
    }

    return instances;
  }

  @GetMapping("/client5")
  public ServiceInstance client5() {
    // ribbon 完成客户端负载均衡
    final ServiceInstance instance = lb.choose("provider");
    String url = "http://" + instance.getHost() + ":" + instance.getPort() + "/getHi";
    final RestTemplate restTemplate = new RestTemplate();
    final String res = restTemplate.getForObject(url, String.class);
    System.out.println(res);
    return instance;
  }

  @GetMapping("/getHi")
  public String getHi() {
    return "Hi";
  }
}
