package com.mooc.jiangzh.springcloud.cinema.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.google.common.collect.Maps;
import com.mooc.jiangzh.springcloud.cinema.controller.vo.CinemaAddReqVO;
import com.mooc.jiangzh.springcloud.cinema.dao.entity.MoocCinemaT;
import com.mooc.jiangzh.springcloud.cinema.service.CinemaServiceAPI;
import com.mooc.jiangzh.springcloud.exception.CommonServiceException;
import com.mooc.jiangzh.springcloud.response.BaseResponseVO;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : jiangzh
 * @program : com.mooc.jiangzh.springcloud.cinema.controller
 * @description : 影院相关的表现层
 * @date : 2019-09-27 17:55
 **/
@RestController
@RequestMapping(value = "/cinemas/")
public class CinemaController {

  @Autowired
  private CinemaServiceAPI cinemaServiceAPI;

  @RequestMapping(value = "/cinema:add", method = RequestMethod.POST)
  public BaseResponseVO addCinema(@RequestBody CinemaAddReqVO cinemaAddReqVO) {
    BaseResponseVO baseResponseVO = null;
    try {
      cinemaAddReqVO.checkParams();
      cinemaServiceAPI.addCinema(cinemaAddReqVO);

      baseResponseVO = BaseResponseVO.success();
    } catch (CommonServiceException e) {
      baseResponseVO = BaseResponseVO.serviceException(e);
    }
    return baseResponseVO;
  }

  @RequestMapping(value = "/cinemalist", method = RequestMethod.GET)
  public BaseResponseVO describeCinemas(
      @RequestParam(name = "nowPage", defaultValue = "1") int nowPage,
      @RequestParam(name = "pageSize", defaultValue = "10") int pageSize) {
    BaseResponseVO baseResponseVO = null;
    try {

      IPage<MoocCinemaT> page = cinemaServiceAPI.describeCinemas(nowPage, pageSize);

      Map<String, Object> result = Maps.newHashMap();
      result.put("nowPage", page.getCurrent());
      result.put("pageSize", page.getSize());
      result.put("totalPages", page.getPages());
      result.put("totalSize", page.getTotal());

      if(page.getSize() == 0){
        baseResponseVO = BaseResponseVO.success();
      }else{
        List<CinemaAddReqVO> cinemas =
            page.getRecords().stream().map((entity) -> {
              return CinemaAddReqVO.pojo2VO(entity);
            }).collect(Collectors.toList());

        result.put("cinemas", cinemas);
        baseResponseVO = BaseResponseVO.success();
      }
    } catch (CommonServiceException e) {
      baseResponseVO = BaseResponseVO.serviceException(e);
    }
    return baseResponseVO;
  }

}
