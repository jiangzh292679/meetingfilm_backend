package com.mooc.jiangzh.springcloud.hall.controller.vo;

import com.mooc.jiangzh.springcloud.common.vo.BaseRequestVO;
import com.mooc.jiangzh.springcloud.exception.CommonServiceException;
import lombok.Data;

/**
 * @author : jiangzh
 * @program : com.mooc.jiangzh.springcloud.film.controller
 * @description : 分页请求对象
 **/
@Data
public class PageReqVO extends BaseRequestVO {

  private Integer nowPage;
  private Integer pageSize;
  private String cinemaId;

  @Override
  public void checkParams() throws CommonServiceException {
    if(nowPage == null || nowPage==0){
      nowPage = 1;
    }
    if(pageSize == null || pageSize==0){
      pageSize = 10;
    }
  }
}
