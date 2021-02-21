package com.movosoft.zuulgateway.filter.pre;

import com.movosoft.zuulgateway.constant.ZuulFilterTypeConstant;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class PreRequestFinderFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return ZuulFilterTypeConstant.PRE;
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
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        System.out.println(String.format("Send %s request to %s!", request.getMethod(), request.getRequestURL()));
        HttpServletResponse response = ctx.getResponse();
        try {
            response.setHeader("Content-Type", "text/html;charset=UTF-8");
            String redirectUrl = request.getParameter("redirect-url");
            if(redirectUrl != null) {
                response.sendRedirect(redirectUrl);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
