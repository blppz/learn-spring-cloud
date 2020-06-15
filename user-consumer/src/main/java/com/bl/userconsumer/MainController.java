package com.bl.userconsumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Deacription TODO
 * @Author BarryLee
 * @Date 2020/6/15 21:31
 */
@RestController
public class MainController {
  @Autowired
  private UserApi api;

  @GetMapping("/alive")
  public String alive() {
    return api.alive();
  }
}
