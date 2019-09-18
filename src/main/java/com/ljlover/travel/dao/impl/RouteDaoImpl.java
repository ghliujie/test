package com.ljlover.travel.dao.impl;

import com.ljlover.travel.dao.RouteDao;
import com.ljlover.travel.domain.Route;
import com.ljlover.travel.util.JDBCUtils;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @Program travel
 * @Description
 * @Author ljlover
 * @Date 2019/8/9 9:49
 * All rights reserved.
 */

public class RouteDaoImpl implements RouteDao {


    JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public int findTotalCount(int cid, String rname) {

        String basesql = "select count(*) from route where 1=1";
        StringBuilder sql = new StringBuilder(basesql);

        List<Serializable> params = new ArrayList<>();

        getSql(cid, rname, sql, params);

        return template.queryForObject(sql.toString(), Integer.class, params.toArray());

    }


    @Override
    public List<Route> findByPage(int cid, int start, int pageSize, String rname) {

        String basesql = "select * from route where 1=1";

        StringBuilder sql = new StringBuilder(basesql);

        List<Serializable> params;
        params = new ArrayList<>();
        getSql(cid, rname, sql, params);

        params.add(start);
        params.add(pageSize);

        sql.append(" limit ?,?");

        return template.query(sql.toString(), new BeanPropertyRowMapper<Route>(Route.class), params.toArray());
    }

    @Override
    public Route findOne(int rid) {
        String sql = "select * from route where rid=?;";
        return template.queryForObject(sql, new BeanPropertyRowMapper<Route>(Route.class), rid);
    }


    private void getSql(int cid, String rname, StringBuilder sql, List params) {
        if (cid != 0) {
            sql.append(" and cid=?");
            params.add(cid);
        }

        if (rname != null && rname.length() > 0) {
            sql.append(" and rname like ?");
            params.add("%" + rname + "%");
        }
    }
}
