package com.mooc.jiangzh.springcloud.hall.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mooc.jiangzh.springcloud.exception.CommonServiceException;
import com.mooc.jiangzh.springcloud.hall.controller.vo.HallReqVO;
import com.mooc.jiangzh.springcloud.hall.controller.vo.HallsRespVO;

/**
 * @author : jiangzh
 * @program : com.mooc.jiangzh.springcloud.hall.service
 * @description : 院线接口
 * @date : 2019-10-14 18:29
 **/
public interface HallServiceAPI {

  void addHall(HallReqVO hallVO) throws CommonServiceException;

  IPage<HallsRespVO> describeHalls(int nowPage, int pageSize,String cinemaId) throws CommonServiceException;

}
