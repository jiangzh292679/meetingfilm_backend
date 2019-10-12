package com.mooc.jiangzh.springcloud.response;

import com.mooc.jiangzh.springcloud.exception.CommonServiceException;
import lombok.Data;

@Data
public class BaseResponseVO<M> {

  private Integer code;
  private String message;
  private M data;

  private BaseResponseVO(){}

  public static<M> BaseResponseVO<M> success(){
    BaseResponseVO baseResponseVO = new BaseResponseVO();
    baseResponseVO.setCode(200);
    return baseResponseVO;
  }

  public static<M> BaseResponseVO<M> success(String message){
    BaseResponseVO baseResponseVO = new BaseResponseVO();
    baseResponseVO.setCode(200);
    baseResponseVO.setMessage(message);
    return baseResponseVO;
  }

  public static<M> BaseResponseVO<M> success(M data){
    BaseResponseVO baseResponseVO = new BaseResponseVO();
    baseResponseVO.setCode(200);
    baseResponseVO.setData(data);
    return baseResponseVO;
  }

  public static<M> BaseResponseVO<M> success(String message,M data){
    BaseResponseVO baseResponseVO = new BaseResponseVO();
    baseResponseVO.setCode(200);
    baseResponseVO.setMessage(message);
    baseResponseVO.setData(data);
    return baseResponseVO;
  }

  public static<M> BaseResponseVO<M> serviceException(CommonServiceException e){
    BaseResponseVO baseResponseVO = new BaseResponseVO();
    baseResponseVO.setCode(e.getCode());
    baseResponseVO.setMessage(e.getMessage());

    return baseResponseVO;
  }

  public static<M> BaseResponseVO<M> systemException(Exception e){
    BaseResponseVO baseResponseVO = new BaseResponseVO();
    baseResponseVO.setCode(500);
    baseResponseVO.setMessage(e.getMessage());

    return baseResponseVO;
  }

  public static<M> BaseResponseVO<M> noLogin(){
    BaseResponseVO baseResponseVO = new BaseResponseVO();
    baseResponseVO.setCode(401);
    baseResponseVO.setMessage("User authentication failed");

    return baseResponseVO;
  }

}
