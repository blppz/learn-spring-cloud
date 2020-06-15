package com.bl.userconsumer;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Deacription 定义接口--api，通过这个接口，Feign帮我们调了UserProvider
 * @Author BarryLee
 * @Date 2020/6/15 21:36
 */
/**
 * 不结合eureka，就是自定义一个client名字。就用url属性指定 服务器列表。url=“http://ip:port/”
 * 这一段在md-按组件分06里，实现比较赤裸
 * 这里的name只是定义了一个名字，没有实质性用处
 */
@FeignClient(name = "xxoo", url = "http://localhost:9090")
public interface UserApi {

  // 所谓OpenFeign可以识别SpringMVC注解，就是识别这个GetMapping，然后拼接到上边的url
  @GetMapping("/alive")
  String alive();
}
