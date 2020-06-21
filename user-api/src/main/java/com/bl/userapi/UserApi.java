package com.bl.userapi;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Deacription 定义这个专门的API
 * 1.maven打包，然后复制pom里面的版本等信息，粘贴到User-Consumer中
 * 2.User-Provider中也添加依赖，Controller中需要实现api接口
 * 双方编程就面向接口了
 * @Author BarryLee
 * @Date 2020/6/15 22:28
 */
//@RequestMapping("/user")
public interface UserApi {
  @GetMapping("/alive")
  String alive();

  @GetMapping("/alive2")
  String alive2();

  @PostMapping("/postPerson")
  Person postPerson(@RequestBody Person person);

}
