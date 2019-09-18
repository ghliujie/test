package com.ljlover.travel.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Program travel
 * @Description  处理中文数据乱码
 * @Author ljlover
 * @Date 2019/8/7 14:50
 * All rights reserved.
 */


@WebFilter("/*")
public class CharacterEncodingFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest)servletRequest;
        HttpServletResponse response = (HttpServletResponse)servletResponse;


        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        filterChain.doFilter(request,response);

    }

    @Override
    public void destroy() {

    }
}
