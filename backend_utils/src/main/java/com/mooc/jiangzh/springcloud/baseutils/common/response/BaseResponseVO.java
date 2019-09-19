package com.mooc.jiangzh.springcloud.baseutils.common.response;

import com.mooc.jiangzh.springcloud.baseutils.common.exception.CommonServiceException;
import lombok.Data;

@Data
public class BaseResponseVO<M> {

  private Integer code;
  private String message;
  private M data;

  private  BaseResponseVO(){}

  public static<M> BaseResponseVO<M> success(String requestId){
    BaseResponseVO baseResponseVO = new BaseResponseVO();
    baseResponseVO.setCode(200);
    return baseResponseVO;
  }

  public static<M> BaseResponseVO<M> success(String requestId,String message){
    BaseResponseVO baseResponseVO = new BaseResponseVO();
    baseResponseVO.setCode(200);
    return baseResponseVO;
  }

  public static<M> BaseResponseVO<M> success(String requestId,String message,M data){
    BaseResponseVO baseResponseVO = new BaseResponseVO();
    baseResponseVO.setCode(200);
    baseResponseVO.setMessage(message);
    baseResponseVO.setData(data);
    return baseResponseVO;
  }

  public static<M> BaseResponseVO<M> serviceException(String requestId, CommonServiceException e){
    BaseResponseVO baseResponseVO = new BaseResponseVO();
    baseResponseVO.setCode(e.getCode());
    baseResponseVO.setMessage(e.getMessage());

    return baseResponseVO;
  }


}
