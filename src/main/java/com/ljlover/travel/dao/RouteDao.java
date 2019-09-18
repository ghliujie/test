package com.ljlover.travel.dao;

import com.ljlover.travel.domain.Route;

import java.util.List;

/**
 * @Program travel
 * @Descriptiion
 * @Author ljlover
 * @Date 2019/8/9 9:46
 * All rights reserved.
 */

public interface RouteDao {

    /**
     * 查询总总记录数
     *
     * @param cid
     * @return
     */
    int findTotalCount(int cid, String rname);

    /**
     * 根据cid，start，pageSize查询当前页的信息
     *
     * @param cid
     * @param start
     * @param pageSize
     * @return
     */
    List<Route> findByPage(int cid, int start, int pageSize, String rname);


    /**
     * 根据id查询信息
     *
     * @param rid
     * @return
     */
    Route findOne(int rid);
}
