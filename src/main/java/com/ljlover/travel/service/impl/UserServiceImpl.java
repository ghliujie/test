package com.ljlover.travel.service.impl;

import com.ljlover.travel.dao.UserDao;
import com.ljlover.travel.dao.impl.UserDaoImpl;
import com.ljlover.travel.domain.User;
import com.ljlover.travel.service.UserService;
import com.ljlover.travel.util.MailUtil;
import com.ljlover.travel.util.UuidUtil;

/**
 * @Program travel
 * @Description UserService实现类
 * @Author ljlover
 * @Date 2019/8/7 14:48
 * All rights reserved.
 */

public class UserServiceImpl implements UserService {

    private UserDao userDao = new UserDaoImpl();

    /**
     * 注册用户方法实现
     *
     * @param user 用户
     * @return 注册状态
     */
    @Override
    public boolean regist(User user) {

        User byUsername = userDao.findByUsername(user.getUsername());

        // 用户存在
        if (byUsername != null) {
            return false;
        }

        // 设置唯一激活码
        user.setCode(UuidUtil.getUuid());

        // 设置激活状态 未激活
        user.setStatus("N");

        userDao.saveUser(user);

        //发送邮件激活账户
        String content = "<a href='http://localhost:8080/travel/user/active?code="+user.getCode()+"'>点击激活</a>【旅游网】";

        System.out.println(content);

        MailUtil.sendMail(user.getEmail(), content, "激活邮件");

        return true;
    }

    @Override
    public boolean active(String code) {


        User user = userDao.findByCode(code);
        if (user != null) {
            userDao.updateStatus(user);
            return true;
        }

        return false;
    }

    @Override
    public User login(User user) {
        return userDao.findByUsernameAndPassword(user.getUsername(),user.getPassword());
    }
}
