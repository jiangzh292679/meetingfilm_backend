package com.mooc.jiangzh.springcloud.conf;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author : jiangzh
 * @program : com.mooc.jiangzh.springcloud.conf
 * @description : REST调用工具类
 * @date : 2019-10-14 18:41
 **/
@Configuration
public class RestConfig {

  @Bean
  @LoadBalanced
  public RestTemplate restTemplate(){
    return new RestTemplate();
  }

}
