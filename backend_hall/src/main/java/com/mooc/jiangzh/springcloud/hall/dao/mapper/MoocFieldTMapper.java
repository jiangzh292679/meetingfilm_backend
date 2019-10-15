package com.mooc.jiangzh.springcloud.hall.dao.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mooc.jiangzh.springcloud.hall.controller.vo.HallsRespVO;
import com.mooc.jiangzh.springcloud.hall.dao.entity.MoocFieldT;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 放映场次表 Mapper 接口
 * </p>
 *
 * @author jiangzh
 * @since 2019-10-14
 */
public interface MoocFieldTMapper extends BaseMapper<MoocFieldT> {

  IPage<HallsRespVO> describeHalls(Page<HallsRespVO> page);
}
