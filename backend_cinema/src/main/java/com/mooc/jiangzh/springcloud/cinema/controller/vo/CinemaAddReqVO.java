package com.mooc.jiangzh.springcloud.cinema.controller.vo;

import com.mooc.jiangzh.springcloud.cinema.dao.entity.MoocCinemaT;
import com.mooc.jiangzh.springcloud.common.vo.BaseRequestVO;
import com.mooc.jiangzh.springcloud.exception.CommonServiceException;
import lombok.Data;

/**
 * @author : jiangzh
 * @program : com.mooc.jiangzh.springcloud.cinema.controller.vo
 * @description : 添加Cinema的对象
 * @date : 2019-09-27 17:58
 **/
@Data
public class CinemaAddReqVO extends BaseRequestVO {

  private Integer brandId; // 品牌编号
  private Integer areaId;  // 区域编号
  private String hallTypeIds; // 影厅类型编号, 多个以#号分割

  private String cinemaName; // 影院名称
  private String cinemaAddress; // 影院地址
  private String cinemaTele; // 影院电话
  private String cinemaImgAddress; // 影院主图地址
  private Double cinemaPrice; // 影院最低票价

  public static CinemaAddReqVO pojo2VO(MoocCinemaT moocCinemaT){
    CinemaAddReqVO cinemaAddReqVO = new CinemaAddReqVO();

    if(moocCinemaT !=null && moocCinemaT.getUuid() != null){
      cinemaAddReqVO.setBrandId(moocCinemaT.getBrandId());
      cinemaAddReqVO.setAreaId(moocCinemaT.getAreaId());
      cinemaAddReqVO.setHallTypeIds(moocCinemaT.getHallIds());
      cinemaAddReqVO.setCinemaName(moocCinemaT.getCinemaName());
      cinemaAddReqVO.setCinemaAddress(moocCinemaT.getCinemaAddress());
      cinemaAddReqVO.setCinemaTele(moocCinemaT.getCinemaPhone());
      cinemaAddReqVO.setCinemaImgAddress(moocCinemaT.getImgAddress());
      cinemaAddReqVO.setCinemaPrice(moocCinemaT.getMinimumPrice());
    }

    return cinemaAddReqVO;
  }

  @Override
  public void checkParams() throws CommonServiceException {
    // TODO 验证品牌编号、区域编号在字典表中是否存在
    // TODO 影厅类型编号格式是否为#号分割，以及编号在字典表中是否存在
  }
}
