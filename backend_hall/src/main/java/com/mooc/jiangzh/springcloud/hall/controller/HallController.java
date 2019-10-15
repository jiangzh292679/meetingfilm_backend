package com.mooc.jiangzh.springcloud.hall.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mooc.jiangzh.springcloud.baseutils.helpers.PageResultHelper;
import com.mooc.jiangzh.springcloud.exception.CommonServiceException;
import com.mooc.jiangzh.springcloud.hall.controller.vo.HallReqVO;
import com.mooc.jiangzh.springcloud.hall.controller.vo.HallsRespVO;
import com.mooc.jiangzh.springcloud.hall.controller.vo.PageReqVO;
import com.mooc.jiangzh.springcloud.hall.service.FilmServiceAPI;
import com.mooc.jiangzh.springcloud.hall.service.HallServiceAPI;
import com.mooc.jiangzh.springcloud.response.BaseResponseVO;
import com.mooc.jiangzh.springcloud.vo.DescribeFilmRepVO;
import java.util.Map;
import javax.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : jiangzh
 * @program : com.mooc.jiangzh.springcloud.hall.controller
 * @description : 院线服务表现层
 * @date : 2019-10-14 18:26
 **/
@Slf4j
@RestController
public class HallController {

  @Autowired
  private HallServiceAPI hallServiceAPI;

  @RequestMapping(value = "/halls:add", method = RequestMethod.POST)
  public BaseResponseVO addHall(@RequestBody HallReqVO hallVO) throws CommonServiceException {

    hallServiceAPI.addHall(hallVO);

    return BaseResponseVO.success();
  }

  @RequestMapping(value = "/halls", method = RequestMethod.GET)
  public BaseResponseVO describeHalls(PageReqVO pageReqVO) throws CommonServiceException {

    IPage<HallsRespVO> hallsRespVOIPage = hallServiceAPI
        .describeHalls(pageReqVO.getNowPage(), pageReqVO.getPageSize());

    Map<String,Object> result = PageResultHelper.getPageResult(hallsRespVOIPage,"actors");

    return BaseResponseVO.success(result);
  }

}
