package com.ljlover.travel.service;

import com.ljlover.travel.domain.User;

/**
 * @Program travel
 * @Descriptiion
 * @Author ljlover
 * @Date 2019/8/7 14:48
 * All rights reserved.
 */

public interface UserService {
    /**
     * 注册用户
     *
     * @param user
     * @return
     */
    boolean regist(User user);


    /**
     * 校验验证码
     *
     * @param code
     * @return
     */
    boolean active(String code);


    /**
     * 用户登录
     *
     * @param user
     * @return
     */
    User login(User user);
}
