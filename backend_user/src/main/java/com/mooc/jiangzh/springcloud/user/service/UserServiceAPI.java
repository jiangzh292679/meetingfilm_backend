package com.mooc.jiangzh.springcloud.user.service;


import com.mooc.jiangzh.springcloud.baseutils.common.exception.CommonServiceException;

public interface UserServiceAPI {

  void login(String userName,String password) throws CommonServiceException;

}
