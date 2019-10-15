package com.mooc.jiangzh.springcloud.hall.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mooc.jiangzh.springcloud.exception.CommonServiceException;
import com.mooc.jiangzh.springcloud.hall.controller.vo.HallReqVO;
import com.mooc.jiangzh.springcloud.hall.controller.vo.HallsRespVO;
import com.mooc.jiangzh.springcloud.hall.dao.entity.MoocFieldT;
import com.mooc.jiangzh.springcloud.hall.dao.entity.MoocHallFilmInfoT;
import com.mooc.jiangzh.springcloud.hall.dao.mapper.MoocFieldTMapper;
import com.mooc.jiangzh.springcloud.hall.dao.mapper.MoocHallFilmInfoTMapper;
import com.mooc.jiangzh.springcloud.response.BaseResponseVO;
import com.mooc.jiangzh.springcloud.utils.ToolUtils;
import com.mooc.jiangzh.springcloud.vo.DescribeFilmRepVO;
import javax.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author : jiangzh
 * @program : com.mooc.jiangzh.springcloud.hall.service
 * @description : 院线服务层实现
 * @date : 2019-10-14 18:29
 **/
@Slf4j
@Service
public class HallServiceImpl implements HallServiceAPI{

  @Resource
  private MoocFieldTMapper fieldMapper;

  @Resource
  private MoocHallFilmInfoTMapper filmInfoMapper;

  @Resource
  private FilmServiceAPI serviceAPI;

  @Override
  @Transactional(rollbackFor = Exception.class)
  public void addHall(HallReqVO hallVO) throws CommonServiceException {
    try{
      // 远程调用，获取影院信息
      DescribeFilmRepVO describeFilmRepVO = describeFilmRepVO(hallVO.getFilmId());
      if(describeFilmRepVO == null || ToolUtils.strIsNull(describeFilmRepVO.getFilmId())){
        throw new CommonServiceException(404,"电影编号不存在");
      }
      // 添加影院信息
      MoocHallFilmInfoT filmInfo = new MoocHallFilmInfoT();
      filmInfo.setFilmId(ToolUtils.str2Int(hallVO.getFilmId()));
      filmInfo.setFilmName(describeFilmRepVO.getFilmName());
      filmInfo.setFilmLength(describeFilmRepVO.getFilmLength());
      filmInfo.setFilmCats(describeFilmRepVO.getFilmCats());
      filmInfo.setActors(describeFilmRepVO.getActors());
      filmInfo.setImgAddress(describeFilmRepVO.getImgAddress());


      filmInfoMapper.insert(filmInfo);
      // 添加影厅信息
      MoocFieldT field = new MoocFieldT();
      field.setCinemaId(ToolUtils.str2Int(hallVO.getCinemaId()));
      field.setFilmId(ToolUtils.str2Int(hallVO.getFilmId()));
      field.setBeginTime(hallVO.getBeginTime());
      field.setEndTime(hallVO.getEndTime());
      field.setHallId(ToolUtils.str2Int(hallVO.getHallTypeId()));
      field.setHallName(hallVO.getHallName());
      field.setPrice(ToolUtils.str2Int(hallVO.getFilmPrice()));

      fieldMapper.insert(field);
    }catch (Exception e){
      log.error("addHall exception hallVO:{} e:{}",hallVO,e);
      throw new CommonServiceException(500, e.getMessage());
    }
  }

  private DescribeFilmRepVO describeFilmRepVO(String filmId) throws CommonServiceException {

    BaseResponseVO<DescribeFilmRepVO> describeFilmRepVOBaseResponseVO = serviceAPI
        .describeFilmRespVO(filmId);

    DescribeFilmRepVO result = describeFilmRepVOBaseResponseVO.getData();

    return result;
  }

  @Override
  public IPage<HallsRespVO> describeHalls(int nowPage, int pageSize) throws CommonServiceException {
    try{
      // 查询影厅信息
      Page<HallsRespVO> page = new Page<>(nowPage,pageSize);

      return fieldMapper.describeHalls(page);
    }catch (Exception e){
      log.error("describeHalls exception e:{}",e);
      throw new CommonServiceException(500, e.getMessage());
    }
  }
}
