package com.mooc.jiangzh.springcloud.hall.controller.vo;

import com.mooc.jiangzh.springcloud.common.vo.BaseRequestVO;
import com.mooc.jiangzh.springcloud.exception.CommonServiceException;
import lombok.Data;

/**
 * @author : jiangzh
 * @program : com.mooc.jiangzh.springcloud.hall.controller.vo
 * @description : 新增院线对象
 * @date : 2019-10-14 18:27
 **/
@Data
public class HallReqVO extends BaseRequestVO {

  private String cinemaId;
  private String filmId;
  private String hallTypeId;
  private String beginTime;
  private String endTime;
  private String filmPrice;
  private String hallName;

  @Override
  public void checkParams() throws CommonServiceException {

  }
}
