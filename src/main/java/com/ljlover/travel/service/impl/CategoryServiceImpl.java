package com.ljlover.travel.service.impl;

import com.ljlover.travel.dao.CategoryDao;
import com.ljlover.travel.dao.impl.CategoryDaoImpl;
import com.ljlover.travel.domain.Category;
import com.ljlover.travel.service.CategoryService;
import com.ljlover.travel.util.JedisUtil;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Tuple;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @Program travel
 * @Description
 * @Author ljlover
 * @Date 2019/8/8 21:44
 * All rights reserved.
 */

public class CategoryServiceImpl implements CategoryService {

    private CategoryDao categoryDao = new CategoryDaoImpl();


    /**
     * 查询所有的旅游信息条目
     *
     * @return 查询到的list
     */
    @Override
    public List<Category> findAll() {

        // 利用jedis缓存优化查询

        Jedis jedis = JedisUtil.getJedis();

        Set<Tuple> categories = jedis.zrangeWithScores("category", 0, -1);

        List<Category> categoryList;


        if (categories == null || categories.size() == 0) {

            categoryList = categoryDao.findAll();

            System.out.println("保存category数据到jedis" + categoryList);

            for (Category category : categoryList) {
                jedis.zadd("category", category.getCid(), category.getCname());
            }
        } else {
            System.out.println("读取jedis缓存中category数据：" + categories);

            categoryList = new ArrayList<>();
            for (Tuple tuple : categories) {
                Category category = new Category((int) tuple.getScore(), tuple.getElement());
                categoryList.add(category);
            }
        }

        return categoryList;
    }
}
