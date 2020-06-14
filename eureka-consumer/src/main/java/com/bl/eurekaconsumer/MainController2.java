package com.bl.eurekaconsumer;

import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Deacription TODO
 * @Author BarryLee
 * @Date 2020/6/14 10:04
 */
@RestController
public class MainController2 {

  @Autowired
  RestTemplate restTemplate;
  @Autowired
  LoadBalancerClient lb;

  @GetMapping("/client6")
  public Object client6() {
    final ServiceInstance provider = lb.choose("provider");
    String url = "http://" + provider.getHost() + ":" + provider.getPort() + "/getHi";
    final String res = restTemplate.getForObject(url, String.class);
    System.out.println(res);
    return res;
  }

  AtomicInteger atomicInteger = new AtomicInteger();

  /**
   * 各种自定义负载算法最简单的实现
   */
  @Autowired
  DiscoveryClient discoveryClient;

  @GetMapping("/client7")
  public Object client7() {
    // 拿到服务列表
    final List<ServiceInstance> providers = discoveryClient.getInstances("provider");
    // 自定义随机负载
    // int idx = new Random().nextInt(providers.size());
    // ServiceInstance provider = providers.get(idx);

    // 自定义轮询算法
    int idx = (atomicInteger.incrementAndGet()) % providers.size();
    ServiceInstance provider = providers.get(idx);

    String url = "http://" + provider.getHost() + ":" + provider.getPort() + "/getHi";
    final String res = restTemplate.getForObject(url, String.class);
    System.out.println(res);
    return res;
  }

  /**
   * 测试配置文件负载算法更换
   * @return
   */
  @GetMapping("/client8")
  public Object client8() {
    final ServiceInstance provider = lb.choose("provider");
    String url = "http://" + provider.getHost() + ":" + provider.getPort() + "/getHi";
    final String res = restTemplate.getForObject(url, String.class);
    System.out.println(res);
    return res;
  }

  /**
   * 自动处理URL，不用手动拼接,需要LoadBalanced注解加在restTemplate上
   * @return
   */
  @GetMapping("/client9")
  public Object client9() {
    // http://服务主机名/资源名
    String url = "http://provider/getHi";
    final String res = restTemplate.getForObject(url, String.class);
    System.out.println(res);
    return res;
  }

}