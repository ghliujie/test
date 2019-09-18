package com.ljlover.travel.service;

import com.ljlover.travel.domain.PageBean;
import com.ljlover.travel.domain.Route;

/**
 * @Program travel
 * @Description
 * @Author ljlover
 * @Date 2019/8/9 9:43
 * All rights reserved.
 */

public interface RouteService {


    PageBean<Route> pageQuery(int cid,int currentPage,int pageSize,String rname);

    Route findOne(String rid);
}
