package com.mooc.jiangzh.springcloud.cinema.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mooc.jiangzh.springcloud.cinema.controller.vo.CinemaAddReqVO;
import com.mooc.jiangzh.springcloud.cinema.dao.entity.MoocCinemaT;
import com.mooc.jiangzh.springcloud.cinema.dao.mapper.MoocCinemaTMapper;
import com.mooc.jiangzh.springcloud.exception.CommonServiceException;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * @author : jiangzh
 * @program : com.mooc.jiangzh.springcloud.cinema.service
 * @description : 影院逻辑层实现
 **/
@Service
public class CinemaServiceImpl implements CinemaServiceAPI{

  @Resource
  private MoocCinemaTMapper cinemaMapper;

  @Override
  public void addCinema(CinemaAddReqVO cinemaAddReqVO) throws CommonServiceException {
    MoocCinemaT moocCinemaT = new MoocCinemaT();

    moocCinemaT.setCinemaName(cinemaAddReqVO.getCinemaName());
    moocCinemaT.setCinemaPhone(cinemaAddReqVO.getCinemaTele());
    moocCinemaT.setBrandId(cinemaAddReqVO.getBrandId());
    moocCinemaT.setAreaId(cinemaAddReqVO.getAreaId());
    moocCinemaT.setHallIds(cinemaAddReqVO.getHallTypeIds());
    moocCinemaT.setImgAddress(cinemaAddReqVO.getCinemaImgAddress());
    moocCinemaT.setCinemaAddress(cinemaAddReqVO.getCinemaAddress());
    moocCinemaT.setMinimumPrice(cinemaAddReqVO.getCinemaPrice());

    cinemaMapper.insert(moocCinemaT);
  }

  @Override
  public IPage<MoocCinemaT> describeCinemas(int nowPage, int pageSize)
      throws CommonServiceException {

    Page<MoocCinemaT> page = new Page<>(nowPage,pageSize);

    IPage<MoocCinemaT> moocCinemaTIPage = cinemaMapper.selectPage(page, null);

    return moocCinemaTIPage;
  }
}
