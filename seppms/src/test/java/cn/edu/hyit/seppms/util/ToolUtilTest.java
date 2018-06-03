package cn.edu.hyit.seppms.util;

import org.junit.Test;

public class ToolUtilTest {

    /**
     * 测试获得指定位数随机字符串
     */
    @Test
    public void testRandomString(){
        int length = 4;
        for (int i = 0; i < 10; i++) {
            System.out.println(ToolUtil.getRandomString(length));
        }
    }

    /**
     * 测试获得指定位数随机数字串
     */
    @Test
    public void testRandomNumberString(){
        int length = 4;
        for (int i = 0; i < 10; i++) {
            System.out.println(ToolUtil.getRandomNumberString(length));
        }
    }

}