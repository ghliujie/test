package com.ljlover.travel.web.servlet;

import com.ljlover.travel.domain.PageBean;
import com.ljlover.travel.domain.Route;
import com.ljlover.travel.service.RouteService;
import com.ljlover.travel.service.impl.RouteServiceImpl;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Program travel
 * @Description:
 * @Author: ljlover
 * @Date: 2019/8/9 9:35
 * All rights reserved.
 */

@WebServlet("/route/*")
public class RouteServlet extends BaseServlet {

    RouteService routeService = new RouteServiceImpl();

    /**
     * 分页查询
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void pageQuery(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String currentPageStr = request.getParameter("currentPage");
        String pageSizeStr = request.getParameter("PageSize");
        String cidStr = request.getParameter("cid");

        String rname = request.getParameter("rname");

        if (rname != null && rname.length() > 0 && !"null".equals(rname)) {
            rname = new String(rname.getBytes("iso-8859-1"), "utf-8");
        } else {
            rname = null;
        }

        int cid = 0;
        if (cidStr != null && cidStr.length() > 0 && !"null".equals(cidStr)) {
            cid = Integer.parseInt(cidStr);
        }

        int currentPage;
        if (currentPageStr != null && currentPageStr.length() > 0) {
            currentPage = Integer.parseInt(currentPageStr);
        } else {
            currentPage = 1;
        }

        int pageSize;
        if (pageSizeStr != null && pageSizeStr.length() > 0) {
            pageSize = Integer.parseInt(pageSizeStr);
        } else {
            pageSize = 5;
        }


        PageBean<Route> pageBean = routeService.pageQuery(cid, currentPage, pageSize, rname);

        writeValue(pageBean, response);

    }


    /**
     * 根据id查询具体的旅游线路信息
     *
     * @param request
     * @param response
     * @throws ServletException
     */
    public void findOne(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        String rid = request.getParameter("rid");

        Route route = routeService.findOne(rid);

        writeValue(route,response);

    }

}
