package com.ljlover.travel.util;

import java.util.UUID;

/**
 * @Program travel
 * @Description 随机生成字符串
 * @Author ljlover
 * @Date 2019/8/7 10:37
 * All rights reserved.
 */

public class UuidUtil {

    /**
     * 获得随机字符串
     * @return 字符串
     */
    public static String getUuid() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}
