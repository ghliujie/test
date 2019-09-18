package com.ljlover.travel.service.impl;

import com.ljlover.travel.dao.RouteDao;
import com.ljlover.travel.dao.SellerDao;
import com.ljlover.travel.dao.impl.RouteDaoImpl;
import com.ljlover.travel.dao.RouteImgDao;
import com.ljlover.travel.dao.impl.RouteImgDaoImpl;
import com.ljlover.travel.dao.impl.SellerDaoImpl;
import com.ljlover.travel.domain.PageBean;
import com.ljlover.travel.domain.Route;
import com.ljlover.travel.domain.RouteImg;
import com.ljlover.travel.domain.Seller;
import com.ljlover.travel.service.RouteService;

import java.util.List;

/**
 * @Program travel
 * @Description
 * @Author ljlover
 * @Date 2019/8/9 9:45
 * All rights reserved.
 */

public class RouteServiceImpl implements RouteService {

    private RouteDao routeDao = new RouteDaoImpl();
    private RouteImgDao routeImage = new RouteImgDaoImpl();
    private SellerDao sellerDao = new SellerDaoImpl();

    @Override
    public PageBean<Route> pageQuery(int cid, int currentPage, int pageSize, String rname) {

        PageBean<Route> pageBean = new PageBean<>();

        int totalCount = routeDao.findTotalCount(cid, rname);

        pageBean.setTotalCount(totalCount);
        pageBean.setCurrentPage(currentPage);
        pageBean.setPageSize(pageSize);

        int start = (currentPage - 1) * pageSize;
        List<Route> list = routeDao.findByPage(cid, start, pageSize, rname);
        pageBean.setList(list);

        int totalPage = totalCount % pageSize == 0 ?
                totalCount / pageSize : (totalCount / pageSize) + 1;
        pageBean.setTotalPage(totalPage);


        return pageBean;
    }

    /**
     * 根据id查询
     *
     * @param rid
     * @return
     */
    @Override
    public Route findOne(String rid) {

        Route route = routeDao.findOne(Integer.parseInt(rid));

        List<RouteImg> routeImageList = routeImage.findByRid(route.getRid());
        route.setRouteImgList(routeImageList);

        Seller seller = sellerDao.findById(route.getSid());
        route.setSeller(seller);


        return route;
    }
}
