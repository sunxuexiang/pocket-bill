package com.cloudfly.start.bill.utils;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * @BelongsProject: pocket-bill
 * @BelongsPackage: com.cloudfly.start.bill.utils
 * @Author: wangyun
 * @CreateTime: 2022-12-12  15:47
 * @Description: 日期，时间工具类
 */

public class DateUtil {

    /**
     * 默认日期格式
     */
    public static String DEFAULT_FORMAT = "yyyy-MM-dd";
    /**
     * 格式化日期
     * @param date 日期对象
     * @return String 日期字符串
     */
    public static String formatDate(Date date){
        SimpleDateFormat f = new SimpleDateFormat(DEFAULT_FORMAT);
        String sDate = f.format(date);
        return sDate;
    }

    /**
     * 获取当年的第一天
     * @return
     */
    public static Date getCurrYearFirst(){
        Calendar currCal=Calendar.getInstance();
        int currentYear = currCal.get(Calendar.YEAR);
        return getYearFirst(currentYear);
    }

    /**
     * 获取当年的最后一天
     * @return
     */
    public static Date getCurrYearLast(){
        Calendar currCal=Calendar.getInstance();
        int currentYear = currCal.get(Calendar.YEAR);
        return getYearLast(currentYear);
    }

    /**
     * 获取某年第一天日期
     * @param year 年份
     * @return Date
     */
    public static Date getYearFirst(int year){
        Calendar calendar = Calendar.getInstance();
        calendar.clear();
        calendar.set(Calendar.YEAR, year);
        Date currYearFirst = calendar.getTime();
        return currYearFirst;
    }

    /**
     * 获取某年最后一天日期
     * @return Date
     */
    public static Date getYearLast(int year){
        Calendar calendar = Calendar.getInstance();
        calendar.clear();
        calendar.set(Calendar.YEAR, year);
        calendar.roll(Calendar.DAY_OF_YEAR, -1);
        Date currYearLast = calendar.getTime();
        return currYearLast;
    }

    /**
     * 获取当月第一天日期
     * @return Date
     */
    public static Date getMonthFirstDay(){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        return calendar.getTime();
    }

    /**
     * 获取当月第一天日期
     * @return Date
     */
    public static Date getMonthLastDay(){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.roll(Calendar.DAY_OF_MONTH, -1);
        return calendar.getTime();
    }


    /**
     * 获取本周第一天
     * @return Date
     * */
    public static Date getWeekFirstDay(){
        Calendar calendar=Calendar.getInstance();
        calendar.add(Calendar.WEEK_OF_MONTH, 0);
        calendar.set(Calendar.DAY_OF_WEEK, 2);
        return calendar.getTime();

    }

    /**
     * 获取本周最后一天
     * @return Date
     * */
    public static Date getWeekLastDay(){
        Calendar calendar=Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_WEEK, calendar.getActualMaximum(Calendar.DAY_OF_WEEK));
        calendar.add(Calendar.DAY_OF_WEEK, 1);
        return calendar.getTime();
    }


    public static String getAfterDay(String date,int num ){
        //用给定的模式和默认语言环境的日期格式符号构造 SimpleDateFormat。
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd ");

        Date dt=null;
        try{
            //解析字符串的文本，生成 Date
            dt=sdf.parse(date);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        //使用默认时区和语言环境获得一个日历。
        Calendar calendar=Calendar.getInstance();
        //使用给定的 Date 设置此 Calendar 的时间。
        calendar.setTime(dt);
        //根据日历的规则，为给定的日历字段添加或减去指定的时间量。
        calendar.add(Calendar.DATE, num);
        //用给定的模式和给定语言环境的默认日期格式符号构造 SimpleDateFormat
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd",
                Locale.ENGLISH);
        //将给定的 Date 格式化为日期/时间字符串,
        //calendar.getTime()返回一个表示此 Calendar 时间值（从历元至现在的毫秒偏移量）的 Date 对象。
        return simpleDateFormat.format(calendar.getTime());
    }

    public static String getBeforeDate(int num){
        //使用默认时区和语言环境获得一个日历。
        Calendar calendar=Calendar.getInstance();
        //new Date()分配 Date 对象并初始化此对象，以表示分配它的时间（精确到毫秒）
        calendar.setTime(new Date());
        //根据日历的规则，为给定的日历字段添加或减去指定的时间量
        calendar.add(Calendar.DATE, -num);
        //用给定的模式和给定语言环境的默认日期格式符号构造 SimpleDateFormat
        SimpleDateFormat simpleDateFormate=new SimpleDateFormat("yyyy-MM-dd",
                Locale.ENGLISH);
        return simpleDateFormate.format(calendar.getTime());

    }
    //获得当前的日期
    public static String getdate(){
        // 分配 Date 对象并初始化此对象，以表示分配它的时间（精确到毫秒）
        Date dt=new Date();
        //dt.getTime()返回自 1970 年 1 月 1 日 00:00:00 GMT 以来此 Date 对象表示的毫秒数。
        long tmlong=dt.getTime();
        //分配 Date 对象并初始化此对象，以表示自从标准基准时间（称为“历元（epoch）”，
        //Date(tmlong)即 1970 年 1 月 1 日 00:00:00 GMT）以来的指定毫秒数。
        return (new java.sql.Date(tmlong).toString());

    }
    //获得当前的日期时间,精确到时分秒,并转化为字符串的形式
    public static String getDateTime(){
        Date dt=new Date();
        long tmlong=dt.getTime();
        //Time(tmlong):使用毫秒时间值构造 Time 对象。
        return (new java.sql.Date(tmlong)+" "+
                (new java.sql.Time(tmlong))).toString();

    }
    //字符串转换成日期时间，不精确到时分秒
    public static Date getStringToDate(String day){
        //用给定的模式和默认语言环境的日期格式符号构造 SimpleDateFormat
        SimpleDateFormat sdf2=new SimpleDateFormat("yyyy-MM-dd");
        Date dt = new Date();
        try{

            dt=sdf2.parse(day);

        }
        catch(Exception e){
            e.printStackTrace();
        }

        // return new java.sql.Date(dt.getTime());
        return dt;
    }


    //字符串转换成日期时间，精确到时分秒
    public static Date getStringToDateTime(String day){
        //用给定的模式和默认语言环境的日期格式符号构造 SimpleDateFormat。
        SimpleDateFormat sdf1=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//HH是24小时制，hh是12小时制
        Date dt = new Date();
        try{

            dt=sdf1.parse(day);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        // return dt;
        return new java.sql.Date(dt.getTime());

    }
    //判断字符串是否可以转换成date格式
    public static boolean isValidDate(String s)
    {
        SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
        // 设置lenient为false. 否则SimpleDateFormat会比较宽松地验证日期，
        //比如2007/02/29会被接受，并转换成2007/03/01
        dateFormat.setLenient(false);
        try
        {
            dateFormat.parse(s);
            return true;
        }
        catch (Exception e)
        {
            // 如果throw java.text.ParseException或者NullPointerException，就说明格式不对
            return false;
        }
    }

    //传入日期格式的时间,并将之转换成字符串
    public static String dateToString(Date date){
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        String day=sdf.format(date);
        return day;
    }

    //将util.date转化为java.sql.Timestamp，以免util.date存入数据库的时时分秒损失
    //此方法可能没什么用
    public static Timestamp getTimestamp(Date date) {
        return new java.sql.Timestamp(date.getTime());
    }
}


