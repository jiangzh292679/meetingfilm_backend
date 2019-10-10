package com.mooc.jiangzh.springcloud.user.controller;

import com.google.common.collect.Maps;
import com.mooc.jiangzh.springcloud.exception.CommonServiceException;
import com.mooc.jiangzh.springcloud.response.BaseResponseVO;
import com.mooc.jiangzh.springcloud.user.controller.vo.LoginUserVO;
import com.mooc.jiangzh.springcloud.user.service.UserServiceAPI;
import com.mooc.jiangzh.springcloud.utils.JwtTokenUtil;
import java.util.Map;
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
  public BaseResponseVO login(@RequestBody LoginUserVO loginUserVO) throws CommonServiceException{
      loginUserVO.checkParams();

      userServiceAPI.login(loginUserVO.getUsername(),loginUserVO.getPassword());

      // 获取JWT的相关信息
      JwtTokenUtil jwtTokenUtil = new JwtTokenUtil();

      String randomKey = jwtTokenUtil.getRandomKey();
      String jwtToken = jwtTokenUtil.generateToken(loginUserVO.getUsername(), randomKey);

      Map<String,String> result = Maps.newHashMap();
      result.put("randomKey",randomKey);
      result.put("token",jwtToken);

      return BaseResponseVO.success(result);
  }

}
