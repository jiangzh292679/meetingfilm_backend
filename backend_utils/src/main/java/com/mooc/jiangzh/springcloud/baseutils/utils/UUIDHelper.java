package com.mooc.jiangzh.springcloud.baseutils.utils;


import java.util.UUID;

public class UUIDHelper {

  private UUIDHelper(){}

  public static String generUUID(){
    return UUID.randomUUID().toString();
  }

}
