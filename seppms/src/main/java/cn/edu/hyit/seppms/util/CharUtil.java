package cn.edu.hyit.seppms.util;

import java.util.Random;

public class CharUtil {
    static Random r = new Random();

    /**
     * 随机得到三个汉字，形成名字
     */
    public static String getName3ZH(){
        int start = 0x4e00;
        int end = 0x9fa5;
        int count = end - start + 1;
        int first = r.nextInt(count) + start;
        int sec = r.nextInt(count) + start;
        int three = r.nextInt(count) + start;
        String name = (char)first + "" + (char)sec + "" + (char)three;
        return name;
    }
}
