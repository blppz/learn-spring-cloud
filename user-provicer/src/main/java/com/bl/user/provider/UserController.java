package com.bl.user.provider;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Deacription TODO
 * @Author BarryLee
 * @Date 2020/6/15 21:23
 */
@RestController
public class UserController {
  @GetMapping("/alive")
  public String alive() {
    return "ok";
  }
}
