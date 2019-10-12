package com.mooc.jiangzh.springcloud.film.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mooc.jiangzh.springcloud.exception.CommonServiceException;
import com.mooc.jiangzh.springcloud.film.controller.vo.DescribeActorsRepVO;
import com.mooc.jiangzh.springcloud.film.controller.vo.DescribeFilmRepVO;
import com.mooc.jiangzh.springcloud.film.controller.vo.DescribeFilmsRepVO;
import com.mooc.jiangzh.springcloud.film.controller.vo.FilmReqVO;
import com.mooc.jiangzh.springcloud.film.dao.entity.MoocActorT;

/**
 * @author : jiangzh
 * @program : com.mooc.jiangzh.springcloud.film.service
 * @description : 接口
 **/
public interface FilmServiceApi {

  void addFilm(FilmReqVO filmReqVO) throws CommonServiceException;

  IPage<DescribeActorsRepVO> describeActors(int nowPage, int pageSize) throws CommonServiceException;

  IPage<DescribeFilmsRepVO> describeFilms(int nowPage, int pageSize) throws CommonServiceException;

  DescribeFilmRepVO describeFilmById(String filmId) throws CommonServiceException;

}
