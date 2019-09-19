package com.mooc.jiangzh.springcloud.user.controller;

import com.mooc.jiangzh.springcloud.baseutils.common.exception.CommonServiceException;
import com.mooc.jiangzh.springcloud.baseutils.common.response.BaseResponseVO;
import com.mooc.jiangzh.springcloud.baseutils.utils.UUIDHelper;
import com.mooc.jiangzh.springcloud.user.controller.vo.LoginUserVO;
import com.mooc.jiangzh.springcloud.user.service.UserServiceAPI;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(value = "/user")
public class UserController {

  @Autowired
  private UserServiceAPI userServiceAPI;

  @RequestMapping(value = "/login",method = RequestMethod.POST)
  public BaseResponseVO login(@RequestBody LoginUserVO loginUserVO){
    String requestId = UUIDHelper.generUUID();
    try {
      userServiceAPI.login(loginUserVO.getUsername(),loginUserVO.getPassword());
      return BaseResponseVO.success(requestId);
    } catch (CommonServiceException e) {
      log.error("login service failture, requestId:{} , loginUserVO:{}, error:{}",requestId,loginUserVO, e);
      return BaseResponseVO.serviceException(requestId,e);
    }
  }

}
