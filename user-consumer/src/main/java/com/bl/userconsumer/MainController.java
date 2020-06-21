package com.bl.userconsumer;

import com.bl.userapi.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @Deacription TODO
 * @Author BarryLee
 * @Date 2020/6/15 21:31
 */
@RestController
public class MainController {
  @Autowired
  private ConsumerApi api;

  //@Autowired
  //MashibingApi mapi;

  @GetMapping("/alive")
  public String alive() {
    /**
     * URL 不能变
     *
     * jar
     * 文档
     */
    return api.alive();
  }

  @Autowired
  private RestService restService;
  @GetMapping("/alive2")
  public String alive2() {
    System.out.println("main controller alive2");
    return restService.alive();
  }


/*  @GetMapping("/vip")
  public String vip() {
    return mapi.getVip();
  }*/

  @GetMapping("/map")
  public Map<Integer, String> map(Integer id) {
    System.out.println(id);
    return api.getMap(id);
  }

  @GetMapping("/map2")
  public Map<Integer, String> map2(Integer id, String name) {
    System.out.println(id);
    System.out.println(name);
    return api.getMap2(id, name);
  }


  @GetMapping("/map3")
  public Map<Integer, String> map3(@RequestParam Map<String, Object> map) {
//		System.out.println(id);
//		HashMap<String, Object> map = new HashMap<>(2);
//
//		map.put("id", id);
//		map.put("name", name);
//		syso
    System.out.println(map);
    return api.getMap3(map);
  }


  @GetMapping("/map4")
  public Map<Integer, String> map4(@RequestParam Map<String, Object> map) {
//		System.out.println(id);
//		HashMap<String, Object> map = new HashMap<>(2);
//
//		map.put("id", id);
//		map.put("name", name);
//		syso
    System.out.println(map);
    return api.postMap(map);
  }

  @GetMapping("/postPerson")
  Person postPerson(@RequestParam Map<Integer, Object> map) {
    System.out.println(map);
    Person person = new Person();
    person.setId(Integer.parseInt(map.get("id").toString()));
    person.setName(map.get("name").toString());
    return api.postPerson(person);
  }
}
