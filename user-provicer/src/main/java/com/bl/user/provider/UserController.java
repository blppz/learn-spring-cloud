package com.bl.user.provider;

import com.bl.userapi.UserApi;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Deacription TODO
 * @Author BarryLee
 * @Date 2020/6/15 21:23
 */
@RestController
public class UserController implements UserApi {
  @GetMapping("/alive")
  @Override
  public String alive() {
    return "ok 123123";
  }
}
