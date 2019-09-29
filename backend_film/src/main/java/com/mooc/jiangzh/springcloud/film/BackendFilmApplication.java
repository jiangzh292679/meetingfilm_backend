package com.mooc.jiangzh.springcloud.film;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class BackendFilmApplication {

  public static void main(String[] args) {
    SpringApplication.run(BackendFilmApplication.class, args);
  }

}
