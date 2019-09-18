package com.ljlover.travel.web.servlet;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

/**
 * @Program travel
 * @Description: 方法的分发
 * @Author: ljlover
 * @Date: 2019/8/8 14:42
 * All rights reserved.
 */

public class BaseServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        String uri = req.getRequestURI();
        System.out.println("uri:" + uri);

        String methodName = uri.substring(uri.lastIndexOf('/') + 1);
        System.out.println("methodName:" + methodName);

        try {
            Method method = this.getClass().getMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);

            // 执行方法
            method.invoke(this, req, resp);

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    /**
     * 序列化对象，返回客户端
     *
     * @param obj
     * @param response
     * @throws IOException
     */
    public void writeValue(Object obj, HttpServletResponse response) throws IOException {

        ObjectMapper mapper = new ObjectMapper();

        response.setContentType("application/json;charset=utf-8");

        mapper.writeValue(response.getOutputStream(), obj);

    }


    /**
     * 序列化对象
     * @param obj 将要序列化的对象
     * @return 序列化字符串
     * @throws JsonProcessingException
     */
    public String writeValueAsString(Object obj) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(obj);
    }
}
