package com.mooc.jiangzh.springcloud.exception;

import com.mooc.jiangzh.springcloud.response.BaseResponseVO;
import javax.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author : jiangzh
 * @program : com.mooc.jiangzh.springcloud.exception
 * @description : 统一异常处理
 **/
@Slf4j
@ControllerAdvice
public class BaseExceptionHandler {

  @ExceptionHandler(CommonServiceException.class)
  @ResponseBody
  public BaseResponseVO handleServiceException(HttpServletRequest request, CommonServiceException ex) {
    log.error("CommonServiceException code:{},msg:{}",ex.getCode(),ex.getMessage());
    return BaseResponseVO.serviceException(ex);
  }

}
