package com.mooc.jiangzh.springcloud.film.controller.vo;

import lombok.Data;

/**
 * @author : jiangzh
 * @program : com.mooc.jiangzh.springcloud.film.controller.vo
 * @description : 影片查询返回对象
 **/
@Data
public class DescribeFilmsRepVO {

  private String filmId;
  private String filmStatus;
  private String filmName;
  private String filmEnName;
  private String filmScore;
  private String preSaleNum;
  private String boxOffice;
  private String filmTime;
  private String filmLength;

}
