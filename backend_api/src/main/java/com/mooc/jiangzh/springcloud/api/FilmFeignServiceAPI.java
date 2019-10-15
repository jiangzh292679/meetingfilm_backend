package com.mooc.jiangzh.springcloud.api;

import com.mooc.jiangzh.springcloud.exception.CommonServiceException;
import com.mooc.jiangzh.springcloud.response.BaseResponseVO;
import com.mooc.jiangzh.springcloud.vo.DescribeFilmRepVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author : jiangzh
 * @program : com.mooc.jiangzh.springcloud.api
 * @description : Film的Feign接口
 * @date : 2019-10-14 18:57
 **/
public interface FilmFeignServiceAPI {

  @RequestMapping(value = "/films/{filmId}", method = RequestMethod.GET)
  BaseResponseVO<DescribeFilmRepVO> describeFilmRespVO(@PathVariable("filmId")String filmId) throws CommonServiceException;

}
