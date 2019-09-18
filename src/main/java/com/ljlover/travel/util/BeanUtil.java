package com.ljlover.travel.util;

import com.ljlover.travel.domain.User;
import org.apache.commons.beanutils.BeanUtils;

import java.util.Map;

/**
 * @Program travel
 * @Description
 * @Author ljlover
 * @Date 2019/8/8 10:59
 * All rights reserved.
 */

public class BeanUtil {

    private static User user;
    static {
        user = new User();
    }

    public static User populate(Map map){
        try {
            BeanUtils.populate(user,map);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

}
