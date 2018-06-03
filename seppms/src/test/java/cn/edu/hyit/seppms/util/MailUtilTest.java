package cn.edu.hyit.seppms.util;

import org.junit.Test;

public class MailUtilTest {

    /**
     * 邮件发送工具类测试
     */
    @Test
    public void test(){
        MailUtil.sendMail("测试主题", "测试内容", "", "目标用户名");
//        MailUtil.sendMail("测试主题", "测试内容", "huangzhengguo@smail.hyit.edu.cn", "目标用户名");
    }

}