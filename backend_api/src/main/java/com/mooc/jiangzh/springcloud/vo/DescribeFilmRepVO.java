package com.mooc.jiangzh.springcloud.vo;

import lombok.Data;

/**
 * @author : jiangzh
 * @program : com.mooc.jiangzh.springcloud.film.controller.vo
 * @description : 根据影片编号查询影片详情实体
 **/
@Data
public class DescribeFilmRepVO {

  private String filmId;
  private String filmName;
  private String filmLength;
  private String filmCats;
  private String filmLanguage;
  private String actors;
  private String imgAddress;
  private String subAddress;

}
