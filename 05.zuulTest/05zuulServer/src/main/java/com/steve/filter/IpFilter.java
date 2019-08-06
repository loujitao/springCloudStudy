package com.steve.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.steve.config.OutIPConfig;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;

/**
 * @Description: IP黑名单过滤器
 * @Author: SteveTao
 * @Date: 2019/8/516:48
 **/
public class IpFilter extends ZuulFilter {

    private Logger logger= LoggerFactory.getLogger(IpFilter.class);

    @Autowired
    private OutIPConfig outIPConfig;


   //类型可选值： pre route  post error
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        //数值越小，优先级越高
        return 1;
    }

    //是否执行该过滤器，true执行，false为不执行
    public boolean shouldFilter() {
//        RequestContext ctx=RequestContext.getCurrentContext();
//        Object success=ctx.get("isSuccess");   //提取上个过滤器的判断值，作为本过滤器执行依据
//        return success==null? true: Boolean.parseBoolean(success.toString());
        return true;
    }

    @Override
    public Object run() {
        RequestContext ctx=RequestContext.getCurrentContext();
        HttpServletRequest servletRequest= ctx.getRequest();
        String ip=servletRequest.getRemoteHost();
        logger.info("=====ip: "+ip);
        // 黑名单禁用
        if(StringUtils.isNotBlank(ip) && outIPConfig!=null &&
                outIPConfig.getIPstr().contains(ip)){
            ctx.setSendZuulResponse(false);
            //过滤器中传递数据
            //ctx.set("isSuccess",false);   //下一个过滤器可以通过ctx取值
            ctx.setResponseBody("{\"msg\":\"非法请求\"，\"code\":403}");
            ctx.getResponse().setContentType("application/json;charset=utf-8");
            return null;
        }
        return null;
    }


}
