package service;

import com.ljlover.travel.domain.User;
import com.ljlover.travel.service.UserService;
import com.ljlover.travel.service.impl.UserServiceImpl;
import org.junit.Test;

/**
 * @Program travel
 * @Description 测试UserService
 * @Author ljlover
 * @Date 2019/8/7 15:33
 * All rights reserved.
 */

public class TestUserService {
    @Test
    public void testRegister() {
        User user = new User(12, "test12333", "test", "test", "1998-04-26", "t", "test", "test", "test", "test");
        user.setEmail("2284687263@qq.com");
        UserService userService = new UserServiceImpl();
        boolean regist = userService.regist(user);
        System.out.println("regist:" + regist);
    }
}
