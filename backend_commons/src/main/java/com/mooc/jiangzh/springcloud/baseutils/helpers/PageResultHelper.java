package com.mooc.jiangzh.springcloud.baseutils.helpers;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.google.common.collect.Maps;
import java.util.Map;

/**
 * @author : jiangzh
 * @program : com.mooc.jiangzh.springcloud.baseutils.helpers
 * @description :
 **/
public class PageResultHelper<M> {

  private PageResultHelper(){}

  public static<M> Map<String,Object> getPageResult(IPage<M> page,String dataName){

    Map<String, Object> result = Maps.newHashMap();
    result.put("nowPage", page.getCurrent());
    result.put("pageSize", page.getSize());
    result.put("totalPages", page.getPages());
    result.put("totalSize", page.getTotal());

    result.put(dataName, page.getRecords());

    return result;
  }

}
