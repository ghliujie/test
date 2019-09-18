package com.ljlover.travel.dao.impl;

import com.ljlover.travel.dao.SellerDao;
import com.ljlover.travel.domain.Seller;
import com.ljlover.travel.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate ;

/**
 * @Program travel
 * @Description
 * @Author ljlover
 * @Date 2019/8/9 16:49
 * All rights reserved.
 */

public class SellerDaoImpl implements SellerDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public Seller findById(int id) {

        String sql = "select * from seller where sid=?;";
        return template.queryForObject(sql, new BeanPropertyRowMapper<Seller>(Seller.class), id);
    }
}
