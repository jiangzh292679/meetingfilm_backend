package com.mooc.jiangzh.springcloud.user.dao;


import com.mooc.jiangzh.springcloud.baseutils.utils.MD5Util;
import com.mooc.jiangzh.springcloud.user.BackendUserApplicationTests;
import com.mooc.jiangzh.springcloud.user.dao.entity.MoocBackendUserT;
import com.mooc.jiangzh.springcloud.user.dao.mapper.MoocBackendUserTMapper;
import java.util.List;
import javax.annotation.Resource;
import org.junit.Test;

public class UserDAOTest extends BackendUserApplicationTests {

  @Resource
  private MoocBackendUserTMapper userTMapper;

  @Test
  public void describeUsers(){
    List<MoocBackendUserT> moocBackendUsers = userTMapper.selectList(null);
    moocBackendUsers.stream().forEach(
        System.out::println
    );
  }

  @Test
  public void saveUser(){
    MoocBackendUserT user = new MoocBackendUserT();
    user.setUserName("admin");
    user.setUserPwd(MD5Util.encrypt("admin"));
    user.setUserPhone("18500000000");

    userTMapper.insert(user);

  }

}
