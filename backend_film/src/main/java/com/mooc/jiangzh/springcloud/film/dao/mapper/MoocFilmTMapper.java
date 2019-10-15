package com.mooc.jiangzh.springcloud.film.dao.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mooc.jiangzh.springcloud.film.controller.vo.DescribeFilmsRepVO;
import com.mooc.jiangzh.springcloud.film.dao.entity.MoocFilmT;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mooc.jiangzh.springcloud.vo.DescribeFilmRepVO;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 影片主表 Mapper 接口
 * </p>
 *
 * @author jiangzh
 */
public interface MoocFilmTMapper extends BaseMapper<MoocFilmT> {

  IPage<DescribeFilmsRepVO> describeFilms(IPage<DescribeFilmsRepVO> page);

  DescribeFilmRepVO describeFilmById(@Param("filmId") String filmId);

}
