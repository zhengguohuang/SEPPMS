package cn.edu.hyit.seppms.util;

import java.util.Random;

/**
 * 高频方法集合类
 */
public class ToolUtil {
    /**
     * 获取随机位数的字符串
     * @author zhengguohuang
     * @Date 2018/6/2 10:48
     */
    public static String getRandomString(int length) {
        String base = "abcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }
        return sb.toString();
    }

    /**
     * 获取随机位数的数字
     * @author zhengguohuang
     * @Date 2018/6/2 10:48
     */
    public static String getRandomNumberString(int length) {
        String base = "0123456789";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }
        return sb.toString();
    }
}
