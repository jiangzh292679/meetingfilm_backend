package com.mooc.jiangzh.springcloud.film.dao.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mooc.jiangzh.springcloud.film.controller.vo.DescribeActorsRepVO;
import com.mooc.jiangzh.springcloud.film.dao.entity.MoocActorT;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import java.util.List;

/**
 * <p>
 * 演员表 Mapper 接口
 * </p>
 *
 * @author jiangzh
 */
public interface MoocActorTMapper extends BaseMapper<MoocActorT> {

  IPage<DescribeActorsRepVO> describeActors(Page<DescribeActorsRepVO> page);


}
