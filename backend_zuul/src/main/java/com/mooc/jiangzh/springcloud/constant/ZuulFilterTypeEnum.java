package com.mooc.jiangzh.springcloud.constant;

/**
 * @author : jiangzh
 * @program : com.mooc.jiangzh.springcloud.constant
 * @description : ZuulFilterType枚举
 **/
public enum  ZuulFilterTypeEnum {

  PRE_TYPE("pre"),ROUTE_TYPE("route"),POST_TYPE("post"),ERROR_TYPE("error");

  private String filterType;

  private ZuulFilterTypeEnum(String filterType){
    this.filterType = filterType;
  }

  public String getFilterType(){
    return this.filterType;
  }

}
