package dao;

import com.ljlover.travel.dao.UserDao;
import com.ljlover.travel.dao.impl.UserDaoImpl;
import com.ljlover.travel.domain.User;
import org.junit.Test;

/**
 * @Program travel
 * @Description  测试UserDao
 * @Author ljlover
 * @Date 2019/8/7 15:37
 * All rights reserved.
 */

public class TestUserDao {

    @Test
    public void testFindByUsername(){
        UserDao userDao = new UserDaoImpl();
        User test = userDao.findByUsername("test");
        System.out.println(test);
    }

    @Test
    public void testSaveUser(){
        User user = new User(113, "test4","test","test","1998-04-26","男","test","test","test","test");
        User user2 = new User(112, "test2","test");
        UserDao userDao = new UserDaoImpl();
        userDao.saveUser(user);

    }
}
