package com.bl.eurekaprovider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;

/**
 * @Deacription TODO
 * @Author BarryLee
 * @Date 2020/6/8 21:47
 */
@RestController
public class ProviderController {

  /**
   * 注入端口，用来区分不同服务
   */
  @Value("${server.port}")
  private int port;

  @GetMapping("/getHi")
  public String getHi() {
    System.out.println("hi");
    return "hi，port==" + port;
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

  /**
   * 用来测试restTemplate接收Map结果
   */
  @GetMapping("/getMap")
  public Map<String, String> getMap() {
    return Collections.singletonMap("id", "123");
  }

}
