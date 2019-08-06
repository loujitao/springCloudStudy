package com.steve.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Description: 异常信息记录过滤器
 * @Author: SteveTao
 * @Date: 2019/8/613:53
 **/
public class ErrorFilter extends ZuulFilter {

    private Logger logger= LoggerFactory.getLogger(ErrorFilter.class);

    @Override
    public String filterType() {
        return "error";
    }

    @Override
    public int filterOrder() {
        return 100;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        RequestContext ctx=RequestContext.getCurrentContext();
//         记录异常信息
        Throwable throwable=ctx.getThrowable();
        logger.error("Filter Error :",throwable.getMessage());
        return null;
    }
}
