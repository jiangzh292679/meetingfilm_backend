package com.mooc.jiangzh.springcloud.filters.pre;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import javax.servlet.http.HttpServletResponse;

/**
 * @author : jiangzh
 * @program : com.mooc.jiangzh.springcloud.filters.pre
 * @description : 解决跨域问题
 * @date : 2019-10-15 10:55
 **/
public class CorsFilter extends ZuulFilter {

  public String filterType() {
    return "pre";
  }

  public int filterOrder() {
    return 0;
  }

  public boolean shouldFilter() {
    return true;
  }

  public Object run() {
    RequestContext ctx = RequestContext.getCurrentContext();
    // 跨域
    HttpServletResponse response = ctx.getResponse();
    response.addHeader("Access-Control-Allow-Origin", "*");
    response.setHeader("Access-Control-Allow-Methods", "*");
    response.setContentType("application/json");
    response.setCharacterEncoding("UTF-8");
    response.setContentType("text/html;charset=UTF-8");

    return null;
  }

}
