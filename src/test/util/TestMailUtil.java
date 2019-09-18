package util;

import com.ljlover.travel.util.MailUtil;
import org.junit.Test;

/**
 * @Program travel
 * @Descriptiion 测试MailUtil
 *
 * @Author ljlover
 * @Date 2019/8/7 9:46
 * All rights reserved.
 */

public class TestMailUtil {

    @Test
    public void testSendMail(){

        MailUtil.sendMail("2284687263@qq.com","<a href='http://localhost/travel/active?code=eafea645a4c24deb8e8be026abe01dab'>点击激活</a>【旅游网】","test测试");

    }

}
