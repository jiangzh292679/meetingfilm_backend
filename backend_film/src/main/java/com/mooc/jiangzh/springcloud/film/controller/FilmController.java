package com.mooc.jiangzh.springcloud.film.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mooc.jiangzh.springcloud.baseutils.helpers.PageResultHelper;
import com.mooc.jiangzh.springcloud.exception.CommonServiceException;
import com.mooc.jiangzh.springcloud.film.controller.vo.DescribeActorsRepVO;
import com.mooc.jiangzh.springcloud.film.controller.vo.DescribeFilmsRepVO;
import com.mooc.jiangzh.springcloud.film.controller.vo.FilmReqVO;
import com.mooc.jiangzh.springcloud.film.controller.vo.PageReqVO;
import com.mooc.jiangzh.springcloud.film.service.FilmServiceApi;
import com.mooc.jiangzh.springcloud.response.BaseResponseVO;
import com.mooc.jiangzh.springcloud.vo.DescribeFilmRepVO;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : jiangzh
 * @program : com.mooc.jiangzh.springcloud.film.controller
 * @description : 电影模块表现层
 **/
@RestController
@RequestMapping(value = "/films")
public class FilmController {

  @Autowired
  private FilmServiceApi filmServiceApi;

  @RequestMapping(value = "/film:add", method = RequestMethod.POST)
  public BaseResponseVO addFilm(@RequestBody FilmReqVO filmReqVO) throws CommonServiceException {

    filmReqVO.checkParams();

    filmServiceApi.addFilm(filmReqVO);

    return BaseResponseVO.success();
  }

  @RequestMapping(value = "", method = RequestMethod.GET)
  public BaseResponseVO describeFilms(PageReqVO pageReqVO) throws CommonServiceException {
    pageReqVO.checkParams();

    IPage<DescribeFilmsRepVO> pages = filmServiceApi.describeFilms(pageReqVO.getNowPage(),pageReqVO.getPageSize());

    Map<String,Object> result = PageResultHelper.getPageResult(pages,"films");

    return BaseResponseVO.success(result);
  }

  @RequestMapping(value = "/actors", method = RequestMethod.GET)
  public BaseResponseVO describeActors(PageReqVO pageReqVO) throws CommonServiceException {
    pageReqVO.checkParams();

    IPage<DescribeActorsRepVO> pages = filmServiceApi.describeActors(pageReqVO.getNowPage(),pageReqVO.getPageSize());

    Map<String,Object> result = PageResultHelper.getPageResult(pages,"actors");

    return BaseResponseVO.success(result);
  }

  @RequestMapping(value = "/{filmId}", method = RequestMethod.GET)
  public BaseResponseVO describeFilmById(@PathVariable(value = "filmId")String filmId) throws CommonServiceException{

    DescribeFilmRepVO describeFilmRepVO = filmServiceApi.describeFilmById(filmId);

    return BaseResponseVO.success(describeFilmRepVO);
  }


}
