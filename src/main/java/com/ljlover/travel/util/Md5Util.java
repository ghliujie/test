package com.ljlover.travel.util;

import java.security.MessageDigest;

/**
 * @Program travel
 * @Description  自定义md5 加密算法
 *
 * @Author ljlover
 * @Date 2019/8/7 10:11
 * All rights reserved.
 */

public class Md5Util {

    private static final String[] HEX = {"0", "1", "2", "3", "4", "5", "6",
            "7", "8", "9", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j",
            "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w",
            "x", "y", "z"};

    private Md5Util() {
    }

    /**
     * MD5加密算法加密密码
     *
     * @param password 需要加密的密码
     * @return 加密后的密码
     * @throws Exception
     */
    public static String encodeByMd5(String password) throws Exception {

        MessageDigest md5 = MessageDigest.getInstance("MD5");

        byte[] digest = md5.digest(password.getBytes());

        return digestToHexString(digest);

    }

    private static String digestToHexString(byte[] digest) {

        StringBuffer buffer = new StringBuffer();

        for (byte b : digest) {
            String hex = byteToString(b);
            buffer.append(hex);
        }

        return buffer.toString();
    }

    private static String byteToString(byte b) {

        int m = b + 128;

        int d1 = m / 8;
        int d2 = m % 32;

        return HEX[d1] + HEX[d2];

    }

}
