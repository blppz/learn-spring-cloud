package com.bl.eurekaconsumer;

import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.Server;

/**
 * @Deacription TODO
 * @Author BarryLee
 * @Date 2020/6/14 11:48
 */
public class MyRule implements IRule {
  @Override
  public Server choose(Object key) {
    return null;
  }

  @Override
  public void setLoadBalancer(ILoadBalancer lb) {

  }

  @Override
  public ILoadBalancer getLoadBalancer() {
    return null;
  }
}
