package com.mooc.jiangzh.springcloud.user.service;


import com.mooc.jiangzh.springcloud.exception.CommonServiceException;

public interface UserServiceAPI {

  void login(String userName,String password) throws CommonServiceException;

}
