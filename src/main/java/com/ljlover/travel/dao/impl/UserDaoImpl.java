package com.ljlover.travel.dao.impl;

import com.ljlover.travel.dao.UserDao;
import com.ljlover.travel.domain.User;
import com.ljlover.travel.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @Program travel
 * @Description UserDao实现类
 * @Author ljlover
 * @Date 2019/8/7 14:49
 * All rights reserved.
 */

public class UserDaoImpl implements UserDao {

    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public User findByUsername(String username) {

        String sql = "select * from user where username=?";
        return getUser(username, sql);
    }

    @Override
    public void saveUser(User user) {

        String sql = "insert into user(username,password,name,birthday,sex,telephone,email,status,code)" +
                "values(?,?,?,?,?,?,?,?,?)";

        template.update(sql, user.getUsername(), user.getPassword(), user.getName(),
                user.getBirthday(), user.getSex(), user.getTelephone(), user.getEmail(),
                user.getStatus(), user.getCode());


    }

    @Override
    public void updateStatus(User user) {

        String sql = "update user set status ='Y'where uid=?";
        template.update(sql, user.getUid());
    }

    @Override
    public User findByCode(String code) {

        String sql = "select * from user where code=?";
        return getUser(code, sql);
    }

    @Override
    public User findByUsernameAndPassword(String username, String password) {
        String sql = "select * from user where username=? and password=?";

        User user = null;
        try {
            user = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), username,password);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return user;
    }

    private User getUser(String code, String sql) {
        User user = null;
        try {
            user = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), code);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return user;
    }
}
