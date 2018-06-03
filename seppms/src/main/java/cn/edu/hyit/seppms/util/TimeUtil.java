package cn.edu.hyit.seppms.util;


import java.util.Date;

public class TimeUtil {
    public static java.sql.Date getCurrentSQLTime(){
        Date date=new Date();
        java.sql.Date sqldate = new java.sql.Date(date.getTime());
        return sqldate;
    }
}
