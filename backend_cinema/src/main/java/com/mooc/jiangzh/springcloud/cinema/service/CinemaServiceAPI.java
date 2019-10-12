package com.mooc.jiangzh.springcloud.cinema.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mooc.jiangzh.springcloud.cinema.controller.vo.CinemaAddReqVO;
import com.mooc.jiangzh.springcloud.cinema.dao.entity.MoocCinemaT;
import com.mooc.jiangzh.springcloud.exception.CommonServiceException;

/**
 * @author : jiangzh
 * @program : com.mooc.jiangzh.springcloud.cinema.service
 * @description : 影院模块逻辑层
 **/
public interface CinemaServiceAPI {

  /** 添加影院方法 */
  void addCinema(CinemaAddReqVO cinemaAddReqVO) throws CommonServiceException;

  /** 查询影院列表 */
  IPage<MoocCinemaT> describeCinemas(int nowPage,int pageSize) throws CommonServiceException;

}
