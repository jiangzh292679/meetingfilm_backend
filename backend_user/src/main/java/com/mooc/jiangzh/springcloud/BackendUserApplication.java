package com.mooc.jiangzh.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;

@EnableDiscoveryClient
@SpringBootApplication
public class BackendUserApplication {

  public static void main(String[] args) {
    SpringApplication.run(BackendUserApplication.class, args);
  }

}
