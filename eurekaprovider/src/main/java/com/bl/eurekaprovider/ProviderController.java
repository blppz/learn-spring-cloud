package com.bl.eurekaprovider;

import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

  @Autowired
  private HealthStatusService healthStatusService;

  /**
   * 用来改变当前服务的状态，测试用
   */
  @GetMapping("/health")
  public String health(@RequestParam("status") Boolean status) {
    // 改变状态
    healthStatusService.setStatus(status);
    // 返回当前状态
    return healthStatusService.getStatus();
  }

}
