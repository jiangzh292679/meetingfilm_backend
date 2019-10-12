package com.mooc.jiangzh.springcloud.common.vo;

import com.mooc.jiangzh.springcloud.exception.CommonServiceException;

/**
 * @author : jiangzh
 * @program : com.mooc.jiangzh.springcloud.common.vo
 * @description : 请求对象的公共父类
 **/
public abstract class BaseRequestVO {

  public abstract void checkParams() throws CommonServiceException;

}
