package com.ljlover.travel.dao;

import com.ljlover.travel.domain.RouteImg;

import java.util.List;

/**
 * @Program travel
 * @Descriptiion
 * @Author ljlover
 * @Date 2019/8/9 16:34
 * All rights reserved.
 */

public interface RouteImgDao {


    /**
     * 根据图片id查询图片集合
     *
     * @param rid
     * @return
     */
    List<RouteImg> findByRid(int rid);

}
