package com.bl.user.provider;

import com.bl.userapi.Person;
import com.bl.userapi.UserApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Deacription TODO
 * @Author BarryLee
 * @Date 2020/6/15 21:23
 */
@RestController
public class UserController implements UserApi {
  /*@GetMapping("/alive")
  @Override
  public String alive() {
    return "ok 123123";
  }*/

  // ----------------------------------

  @Value("${server.port}")
  String port;

  private AtomicInteger count = new AtomicInteger();

  @Override
  public String alive() {
    try {
      System.out.println("准备睡");
      Thread.sleep(3000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    int i = count.getAndIncrement();
    System.out.println("====第：" + i + "次调用，post=" + port);
    return "port:" + port;
  }

  //@Override
  public String getById(Integer id) {
    return null;
  }

  @GetMapping("/getMap")
  public Map<Integer, String> getMap(@RequestParam("id") Integer id) {
    System.out.println(id);
    return Collections.singletonMap(id, "mmeme");
  }

  @GetMapping("/getMap2")
  public Map<Integer, String> getMap2(Integer id, String name) {
    System.out.println(id);
    return Collections.singletonMap(id, name);
  }

  @GetMapping("/getMap3")
  public Map<Integer, String> getMap3(@RequestParam Map<String, Object> map) {
    System.out.println(map);
    return Collections.singletonMap(Integer.parseInt(map.get("id").toString()), map.get("name").toString());
  }


  @PostMapping("/postMap")
  public Map<Integer, String> postMap(@RequestBody Map<String, Object> map) {
    System.out.println(map);
    return Collections.singletonMap(Integer.parseInt(map.get("id").toString()), map.get("name").toString());
  }

  @Override
  public Person postPerson(@RequestBody Person person) {
    System.out.println("---UserController postPerson---");
    System.out.println(person);
    return person;
  }

}
