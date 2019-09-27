package com.mooc.jiangzh.springcloud.filters.pre;

import com.alibaba.fastjson.JSONObject;
import com.mooc.jiangzh.springcloud.constant.ZuulFilterTypeEnum;
import com.mooc.jiangzh.springcloud.properties.JwtProperties;
import com.mooc.jiangzh.springcloud.response.BaseResponseVO;
import com.mooc.jiangzh.springcloud.utils.JwtTokenUtil;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import io.jsonwebtoken.JwtException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;

/**
 * @author : jiangzh
 * @program : com.mooc.jiangzh.springcloud.filters.pre
 * @description : JWT信息验证Filter
 **/
@Component
public class JWTFilter extends ZuulFilter {

  @Override
  public String filterType() {
    return ZuulFilterTypeEnum.PRE_TYPE.getFilterType();
  }

  @Override
  public int filterOrder() {
    return 0;
  }

  @Override
  public boolean shouldFilter() {
    return true;
  }

  @Override
  public Object run() throws ZuulException {
    // JWT工具类
    JwtTokenUtil jwtTokenUtil = new JwtTokenUtil();
    JwtProperties jwtProperties = JwtProperties.getJwtProperties();


    RequestContext ctx = RequestContext.getCurrentContext();
    // 获取当前请求和返回值
    HttpServletRequest request = ctx.getRequest();
    HttpServletResponse response = ctx.getResponse();

    // 提前设置请求继续，如果失败则修改此内容
    ctx.setSendZuulResponse(true);
    ctx.setResponseStatusCode(200);

    if (request.getServletPath().endsWith("/" + jwtProperties.getAuthPath())) {
      return null;
    }

    final String requestHeader = request.getHeader(jwtProperties.getHeader());
    String authToken = null;
    if (requestHeader != null && requestHeader.startsWith("Bearer ")) {
      authToken = requestHeader.substring(7);

      //验证token是否过期,包含了验证jwt是否正确
      try {
        boolean flag = jwtTokenUtil.isTokenExpired(authToken);
        if (flag) {
          renderJson(ctx , response, BaseResponseVO.noLogin());
        }
      } catch (JwtException e) {
        //有异常就是token解析失败
        renderJson(ctx ,response, BaseResponseVO.noLogin());
      }
    } else {
      //header没有带Bearer字段
      renderJson(ctx ,response, BaseResponseVO.noLogin());
    }

    return null;
  }

  /**
   * 渲染json对象
   */
  public static void renderJson(RequestContext ctx,HttpServletResponse response, Object jsonObject) {
      // 设置终止请求
      response.setHeader("Content-Type", "application/json;charset=UTF-8");
      ctx.setSendZuulResponse(false);
      ctx.setResponseBody(JSONObject.toJSONString(jsonObject));
  }

}
