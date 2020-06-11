package com.bl.eurekaprovider;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Deacription TODO
 * @Author BarryLee
 * @Date 2020/6/8 21:47
 */
@RestController
public class MainController {
  @GetMapping("/getHi")
  public String getHi() {
    System.out.println("hi");
    return "hi";
  }
}
