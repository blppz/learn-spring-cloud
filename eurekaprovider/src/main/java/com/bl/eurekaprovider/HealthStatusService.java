package com.bl.eurekaprovider;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Service;

/**
 * @Deacription 改变健康状态的Service
 * @Author BarryLee
 * @Date 2020/6/13 21:30
 */
@Service
public class HealthStatusService implements HealthIndicator {
  private Boolean status = true;

  public void setStatus(Boolean status) {
    this.status = status;
  }

  @Override
  public Health health() {
    if (status) {
      return new Health.Builder().up().build();
    }
    return new Health.Builder().down().build();
  }

  public String getStatus() {
    return this.status.toString();
  }
}
