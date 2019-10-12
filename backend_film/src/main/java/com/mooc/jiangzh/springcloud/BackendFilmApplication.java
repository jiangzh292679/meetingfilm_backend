package com.mooc.jiangzh.springcloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
@MapperScan(basePackages = {"com.mooc.jiangzh.springcloud.film.dao"})
public class BackendFilmApplication {

  public static void main(String[] args) {
    SpringApplication.run(BackendFilmApplication.class, args);
  }

}
