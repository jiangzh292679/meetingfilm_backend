package com.mooc.jiangzh.springcloud.user.controller.vo;

import com.mooc.jiangzh.springcloud.common.vo.BaseRequestVO;
import com.mooc.jiangzh.springcloud.exception.CommonServiceException;
import com.mooc.jiangzh.springcloud.utils.ToolUtils;
import lombok.Data;

@Data
public class LoginUserVO extends BaseRequestVO {

  private String username;
  private String password;

  @Override
  public void checkParams() throws CommonServiceException {

    if(ToolUtils.strIsNull(username) || ToolUtils.strIsNull(password)){
      throw new CommonServiceException(404,"username or password must be required!");
    }

  }
}
