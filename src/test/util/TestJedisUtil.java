package util;

import com.ljlover.travel.util.JedisUtil;
import org.junit.Test;
import redis.clients.jedis.Jedis;

/**
 * @Program travel
 * @Description
 * @Author ljlover
 * @Date 2019/8/9 7:21
 * All rights reserved.
 */

public class TestJedisUtil {

    @Test
    public void testGetJedis() {

        Jedis jedis = JedisUtil.getJedis();

        jedis.set("test","test");


    }

}
