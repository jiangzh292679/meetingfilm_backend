package com.mooc.jiangzh.springcloud.user.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.mooc.jiangzh.springcloud.exception.CommonServiceException;
import com.mooc.jiangzh.springcloud.user.dao.entity.MoocBackendUserT;
import com.mooc.jiangzh.springcloud.user.dao.mapper.MoocBackendUserTMapper;
import com.mooc.jiangzh.springcloud.utils.MD5Util;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserServiceAPI{

  @Resource
  private MoocBackendUserTMapper userTMapper;

  @Override
  public void login(String userName, String password) throws CommonServiceException {

    QueryWrapper wrapper = new QueryWrapper();
    wrapper.eq("user_name", userName);

    List<MoocBackendUserT> users = userTMapper.selectList(wrapper);

    if(users == null || users.size() == 0){
      throw new CommonServiceException(404,"user not registered");
    }else{
      MoocBackendUserT user = users.stream().findFirst().get();
      if(user.getUserPwd().equals(MD5Util.encrypt(password))){
      }else{
        throw new CommonServiceException(500,"username or password is invalid");
      }
    }
  }
}
