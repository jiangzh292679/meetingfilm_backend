package com.mooc.jiangzh.springcloud.film.controller.vo;

import com.mooc.jiangzh.springcloud.common.vo.BaseRequestVO;
import com.mooc.jiangzh.springcloud.exception.CommonServiceException;
import lombok.Data;

/**
 * @author : jiangzh
 * @program : com.mooc.jiangzh.springcloud.film.controller.vo
 * @description : 新增影片请求对象
 **/
@Data
public class FilmReqVO extends BaseRequestVO {

  private String filmStatus;
  private String filmName;
  private String filmEnName;
  private String mainImgAddress;
  private String filmScore;
  private String filmScorers;
  private String preSaleNum;
  private String boxOffice;
  private String filmTypeId;
  private String filmSourceId;
  private String filmCatIds;
  private String areaId;
  private String dateId;
  private String filmTime;
  private String directorId;
  private String actIds;
  private String roleNames;
  private String filmLength;
  private String biography;
  private String filmImgs;


  @Override
  public void checkParams() throws CommonServiceException {

  }
}
