package com.mooc.jiangzh.springcloud.hall;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
@ComponentScan(basePackages = {"com.mooc.jiangzh.springcloud"})
public class BackendHallApplication {

  public static void main(String[] args) {
    SpringApplication.run(BackendHallApplication.class, args);
  }

}
