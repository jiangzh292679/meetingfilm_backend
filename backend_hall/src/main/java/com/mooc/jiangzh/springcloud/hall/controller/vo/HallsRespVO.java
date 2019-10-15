package com.mooc.jiangzh.springcloud.hall.controller.vo;

import lombok.Data;

/**
 * @author : jiangzh
 * @program : com.mooc.jiangzh.springcloud.hall.controller.vo
 * @description : Hall列表查询返回对象
 * @date : 2019-10-14 18:31
 **/
@Data
public class HallsRespVO {

  private String cinemaName;
  private String filmName;
  private String hallTypeName;
  private String beginTime;
  private String endTime;
  private String filmPrice;

}
