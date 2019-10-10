package com.mooc.jiangzh.springcloud.film.controller;

import com.mooc.jiangzh.springcloud.response.BaseResponseVO;
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

  @RequestMapping(value = "", method = RequestMethod.POST)
  public BaseResponseVO addFilm(){

    return null;
  }

}
