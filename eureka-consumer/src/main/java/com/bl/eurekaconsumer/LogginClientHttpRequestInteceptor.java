package com.bl.eurekaconsumer;

import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;

import java.io.IOException;

/**
 * 代理类
 * 拦截restTemplate的http请求
 * @Deacription 自定义http请求的头信息，同时保护get和post方法
 * @Author BarryLee
 * @Date 2020/6/15 20:51
 */
public class LogginClientHttpRequestInteceptor implements ClientHttpRequestInterceptor {

  @Override
  public ClientHttpResponse intercept(HttpRequest request, byte[] bytes, ClientHttpRequestExecution execution) throws IOException {
    System.out.println("拦截到了");
    System.out.println(request.getURI());
    final ClientHttpResponse response = execution.execute(request, bytes);
    System.out.println(response.getHeaders());
    return response;
  }
}
