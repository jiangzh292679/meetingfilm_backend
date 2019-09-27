package com.mooc.jiangzh.springcloud.utils;


import java.util.UUID;

public class UUIDHelper {

  private UUIDHelper(){}

  public static String generUUID(){
    return UUID.randomUUID().toString();
  }

}
