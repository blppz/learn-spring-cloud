package com.bl.userconsumer;

import com.bl.userapi.Person;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * 如果没有@Component，会报错：org.springframework.beans.factory.UnsatisfiedDependencyException:
 * ...... No fallback instance of type class com.bl.userconsumer.UserProviderBack
 * found for feign client user-provider
 * 因为它是一个单例，是spring管理的
 * @Author BarryLee
 * @Date 2020/6/21 16:26
 */
@Component("back1")
public class UserProviderBack implements ConsumerApi{

  @Override
  public String alive() {
    return "降级了";
  }

  @Override
  public Map<Integer, String> getMap(Integer id) {
    return null;
  }

  @Override
  public Map<Integer, String> getMap2(Integer id, String name) {
    return null;
  }

  @Override
  public Map<Integer, String> getMap3(Map<String, Object> map) {
    return null;
  }

  @Override
  public Map<Integer, String> postMap(Map<String, Object> map) {
    return null;
  }

  @Override
  public Person postPerson(Person person) {
    return null;
  }
}
