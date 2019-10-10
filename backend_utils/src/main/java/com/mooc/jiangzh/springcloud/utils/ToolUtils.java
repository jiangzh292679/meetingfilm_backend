package com.mooc.jiangzh.springcloud.utils;

/**
 * @author : jiangzh
 * @program : com.mooc.jiangzh.springcloud.utils
 * @description : 公共工具类
 * @date : 2019-10-10 14:02
 **/
public class ToolUtils {

  private ToolUtils(){}

  public static boolean strIsNull(String str){
    if(str!=null && str.trim().length()>0){
      return false;
    }
    return true;
  }

  public static boolean strIsNotNul(String str){
    if(str!=null && str.trim().length()>0){
      return true;
    }
    return false;
  }

}
