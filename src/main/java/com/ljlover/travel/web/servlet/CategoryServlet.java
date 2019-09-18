package com.ljlover.travel.web.servlet;

import com.ljlover.travel.domain.Category;
import com.ljlover.travel.service.CategoryService;
import com.ljlover.travel.service.impl.CategoryServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @Program travel
 * @Description:
 *
 * @Author: ljlover
 * @Date: 2019/8/8 21:49
 * All rights reserved.
 */

@WebServlet("/category/*")
public class CategoryServlet extends BaseServlet {


    private CategoryService categoryService = new CategoryServiceImpl();

    /**
     * 查询所有的信息
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Category> categoryList = categoryService.findAll();

        writeValue(categoryList,response);
    }


}
