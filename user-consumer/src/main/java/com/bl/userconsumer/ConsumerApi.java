package com.bl.userconsumer;

import com.bl.userapi.UserApi;
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
//@FeignClient(name = "xxoo", url = "http://localhost:9090")

/**
 * 这个是走Eureka、Ribbon的
 * name是服务名，通过这个服务名来匹配服务列表对应ip+port
 * 但是这种方式跟之前的RestTemplate没什么区别，不过没有耦合，没有代码侵入，方便做异构系统
 *
 * 写这个接口，可以给Java用，因为直接调接口很方便，但是不能做异构，比如有PHP，.Net来了，就再写个文档就完事了
 */
@FeignClient(name = "user-provider")
public interface ConsumerApi extends UserApi {

  // extends 自定义 UserApi就不需要自己写下边这些代码了
/*  // 所谓OpenFeign可以识别SpringMVC注解，就是识别这个GetMapping，然后拼接到上边的url
  @GetMapping("/alive")
  String alive();*/
}
