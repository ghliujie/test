package util;

import com.ljlover.travel.util.Md5Util;
import org.junit.Test;

/**
 * @Program travel
 * @Descriptiion
 * @Author ljlover
 * @Date 2019/8/7 10:26
 * All rights reserved.
 */

public class TestMd5Util {

    @Test
    public void testEncodeByMd5() throws Exception {
        String s = Md5Util.encodeByMd5("1234567890");
        System.out.println(s);
    }

}
