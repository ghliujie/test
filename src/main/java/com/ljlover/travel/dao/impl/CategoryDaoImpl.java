package com.ljlover.travel.dao.impl;

import com.ljlover.travel.dao.CategoryDao;
import com.ljlover.travel.domain.Category;
import com.ljlover.travel.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * @Program travel
 * @Description
 *
 * @Author ljlover
 * @Date 2019/8/8 21:41
 * All rights reserved.
 */

public class CategoryDaoImpl implements CategoryDao {


    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public List<Category> findAll() {
        String sql="select * from category";
        return template.query(sql,new BeanPropertyRowMapper<Category>(Category.class));
    }
}
