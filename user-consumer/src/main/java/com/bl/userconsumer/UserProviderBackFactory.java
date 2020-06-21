package com.bl.userconsumer;

import com.bl.userapi.Person;
import feign.FeignException;
import feign.hystrix.FallbackFactory;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpServerErrorException;

import java.util.Map;

/**
 * 这个也要给Spring管理
 * @Author BarryLee
 * @Date 2020/6/21 20:02
 */
@Component
public class UserProviderBackFactory implements FallbackFactory<ConsumerApi> {
  /**
   * 这个异常包括了本地的异常，也包括远端服务的异常
   * @param throwable
   * @return
   */
  @Override
  public ConsumerApi create(Throwable throwable) {
    return new ConsumerApi() {

      @Override
      public String alive() {
        System.out.println("----");
        throwable.printStackTrace();
        if(throwable instanceof FeignException.InternalServerError) {
          return "远程服务器500:"+throwable.getMessage();
        }
        return "xixi";
      }

      @Override
      public String alive2() {
        return null;
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

    };
  }
}
