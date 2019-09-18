package com.ljlover.travel.dao.impl;

import com.ljlover.travel.dao.RouteImgDao;
import com.ljlover.travel.domain.RouteImg;
import com.ljlover.travel.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * @Program travel
 * @Description
 * @Author ljlover
 * @Date 2019/8/9 16:36
 * All rights reserved.
 */

public class RouteImgDaoImpl implements RouteImgDao {

    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public List<RouteImg> findByRid(int rid) {

        String sql = "select * from route_img where rid=?;";
        return template.query(sql, new BeanPropertyRowMapper<RouteImg>(RouteImg.class), rid);
    }

}
