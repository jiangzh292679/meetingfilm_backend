package com.mooc.jiangzh.springcloud.film.service;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mooc.jiangzh.springcloud.film.dao.entity.MoocFilmActorT;
import com.mooc.jiangzh.springcloud.utils.ToolUtils;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mooc.jiangzh.springcloud.exception.CommonServiceException;
import com.mooc.jiangzh.springcloud.film.controller.vo.DescribeActorsRepVO;
import com.mooc.jiangzh.springcloud.film.controller.vo.DescribeFilmsRepVO;
import com.mooc.jiangzh.springcloud.film.controller.vo.FilmReqVO;
import com.mooc.jiangzh.springcloud.film.dao.entity.MoocFilmInfoT;
import com.mooc.jiangzh.springcloud.film.dao.entity.MoocFilmT;
import com.mooc.jiangzh.springcloud.film.dao.mapper.MoocActorTMapper;
import com.mooc.jiangzh.springcloud.film.dao.mapper.MoocFilmActorTMapper;
import com.mooc.jiangzh.springcloud.film.dao.mapper.MoocFilmInfoTMapper;
import com.mooc.jiangzh.springcloud.film.dao.mapper.MoocFilmTMapper;
import com.mooc.jiangzh.springcloud.vo.DescribeFilmRepVO;
import javax.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author : jiangzh
 * @program : com.mooc.jiangzh.springcloud.film.service
 * @description : 实现类
 **/
@Service
@Slf4j
public class FilmServiceImpl implements FilmServiceApi{

  @Resource
  private MoocFilmTMapper filmMapper;
  @Resource
  private MoocFilmInfoTMapper filmInfoMapper;
  @Resource
  private MoocActorTMapper actorMapper;
  @Resource
  private MoocFilmActorTMapper filmActorMapper;

  @Override
  @Transactional(rollbackFor = Exception.class)
  public void addFilm(FilmReqVO filmReqVO) throws CommonServiceException {
    try{
      MoocFilmT film = new MoocFilmT();
      film.setFilmName(filmReqVO.getFilmName());
      film.setFilmType(ToolUtils.str2Int(filmReqVO.getFilmTypeId()));
      film.setImgAddress(filmReqVO.getMainImgAddress());
      film.setFilmScore(filmReqVO.getFilmScore());
      film.setFilmPresalenum(ToolUtils.str2Int(filmReqVO.getPreSaleNum()));
      film.setFilmBoxOffice(ToolUtils.str2Int(filmReqVO.getBoxOffice()));
      film.setFilmSource(ToolUtils.str2Int(filmReqVO.getFilmSourceId()));
      film.setFilmCats(filmReqVO.getFilmCatIds());
      film.setFilmArea(ToolUtils.str2Int(filmReqVO.getAreaId()));
      film.setFilmDate(ToolUtils.str2Int(filmReqVO.getDateId()));
      film.setFilmTime(ToolUtils.str2LocalDateTime(filmReqVO.getFilmTime()+" 00:00:00"));
      film.setFilmStatus(ToolUtils.str2Int(filmReqVO.getFilmStatus()));

      filmMapper.insert(film);

      MoocFilmInfoT filmInfo = new MoocFilmInfoT();
      filmInfo.setFilmId(film.getUuid()+"");
      filmInfo.setFilmEnName(filmReqVO.getFilmEnName());
      filmInfo.setFilmScore(filmReqVO.getFilmScore());
      filmInfo.setFilmScoreNum(ToolUtils.str2Int(filmReqVO.getFilmScorers()));
      filmInfo.setFilmLength(ToolUtils.str2Int(filmReqVO.getFilmLength()));
      filmInfo.setBiography(filmReqVO.getBiography());
      filmInfo.setDirectorId(ToolUtils.str2Int(filmReqVO.getDirectorId()));
      filmInfo.setFilmImgs(filmReqVO.getFilmImgs());

      filmInfoMapper.insert(filmInfo);

      // 演员映射表
      String[] actIds = filmReqVO.getActIds().split("#");
      String[] roleNames = filmReqVO.getRoleNames().split("#");

      // 每个演员必须有一个角色名称
      if(actIds.length != roleNames.length){
        throw new CommonServiceException(500,"演员数与角色名称数不匹配");
      }

      // 循环插入演员和电影的映射表
      for(int i=0;i<actIds.length;i++){
        MoocFilmActorT filmActor = new MoocFilmActorT();
        filmActor.setFilmId(film.getUuid());
        filmActor.setActorId(ToolUtils.str2Int(actIds[i]));
        filmActor.setRoleName(roleNames[i]);

        filmActorMapper.insert(filmActor);
      }


    }catch (Exception e){
      log.error("addFilm exception, reason:{}", e);
      throw new CommonServiceException(500,e.getMessage());
    }
  }

  @Override
  public IPage<DescribeActorsRepVO> describeActors(int nowPage, int pageSize)
      throws CommonServiceException {
    try {
      Page<DescribeActorsRepVO> actors = new Page<>(nowPage,pageSize);

      return actorMapper.describeActors(actors);
    }catch (Exception e){
      log.error("describeActors exception, reason:{}", e);
      throw new CommonServiceException(500,e.getMessage());
    }
  }

  @Override
  public IPage<DescribeFilmsRepVO> describeFilms(int nowPage, int pageSize)
      throws CommonServiceException {

    try {
      IPage<DescribeFilmsRepVO> films = new Page<>(nowPage,pageSize);
      films = filmMapper.describeFilms(films);

      return films;
    }catch (Exception e){
      log.error("describeFilms exception, reason:{}", e);
      throw new CommonServiceException(500,e.getMessage());
    }
  }

  @Override
  public DescribeFilmRepVO describeFilmById(String filmId) throws CommonServiceException {
    try {
      DescribeFilmRepVO describeFilmRepVO = filmMapper.describeFilmById(filmId);

      return describeFilmRepVO;
    }catch (Exception e){
      log.error("describeFilmById exception, reason:{}", e);
      throw new CommonServiceException(500,e.getMessage());
    }
  }

}
