package com.mooc.jiangzh.springcloud.hall.service;

import com.mooc.jiangzh.springcloud.api.FilmFeignServiceAPI;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author : jiangzh
 * @program : com.mooc.jiangzh.springcloud.hall.service
 * @description :
 * @date : 2019-10-14 19:43
 **/
@FeignClient(value = "film-service")
public interface FilmServiceAPI extends FilmFeignServiceAPI {

}
