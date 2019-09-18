package com.ljlover.travel.dao;

import com.ljlover.travel.domain.User;

/**
 * @Program travel
 * @Descriptiion UserDao接口
 * @Author ljlover
 * @Date 2019/8/7 14:49
 * All rights reserved.
 */

public interface UserDao {
    /**
     * 根据用户名查询用户 信息
     *
     * @param username 用户名
     * @return 用户信息
     */
    User findByUsername(String username);


    /**
     * 保存用户信息
     * @param user 用户
     */
    void saveUser(User user);

    /**
     * 更新注册码
     * @param user
     */
    void updateStatus(User user);

    /**
     * 根据注册码查询用户
     * @param code
     * @return
     */
    User findByCode(String code);


    /**
     * 通过用户名和密码查询登录用户
     * @param username
     * @param password
     * @return
     */
    User findByUsernameAndPassword(String username, String password);
}
