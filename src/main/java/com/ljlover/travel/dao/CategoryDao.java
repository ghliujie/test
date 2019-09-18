package com.ljlover.travel.dao;

import com.ljlover.travel.domain.Category;

import java.util.List;

/**
 * @Program travel
 * @Descriptiion 具体数据
 * @Author ljlover
 * @Date 2019/8/8 21:40
 * All rights reserved.
 */

public interface CategoryDao {

    List<Category> findAll();

}
