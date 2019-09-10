package com.xy.studyboot.util;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

/**
 * WJY
 * 1.8时间工具类
 */
public class DateUtil {

    public static void main(String[] args) {
        System.out.println(getMonth(LocalDateTime.now()));
    }

    public static final String DEFAULT_DATE_FORMAT = "yyyy-MM-dd";
    public static final String DEFAULT_TIME_FORMAT = "HH:mm:ss";
    public static final String DEFAULT_DATETIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

    /**
     * 格式化后的日期字符串，默认使用 yyyy-MM-dd HH:mm:ss
     * @param localDateTime
     * @return formatDateToString
     */
    public static String formatDateToString(LocalDateTime localDateTime){
        return localDateTime.format(DateTimeFormatter.ofPattern(DEFAULT_DATETIME_FORMAT));
    }

    /**
     * 根据给定的格式把时间转换为字符串
     * @param localDateTime 要格式化的日期
     * @param format 转换格式
     * @return formatDateToString
     */
    public static String formatDateToString(LocalDateTime localDateTime , String format){
        if (null != localDateTime){
            return localDateTime.format(DateTimeFormatter.ofPattern(format));
        } else {
            return null;
        }
    }

    /**
     * 字符转换为时间，默认使用yyyy-MM-dd HH:mm:ss格式
     * @param date
     * @return LocalDateTime
     */
    public static LocalDateTime formatStringToDate(String date){
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(DEFAULT_DATETIME_FORMAT);
        return LocalDateTime.parse(date,dateTimeFormatter);
    }

    /**
     * 字符转换为时间，默认使用yyyy-MM-dd HH:mm:ss格式
     * @param data 日期字符串
     * @param format 转换格式
     * @return LocalDateTime
     */
    public static LocalDateTime formatStringToDate(String data,String format){
        if (null != data && ! data.equals("")){
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(format);
            return LocalDateTime.parse(data,dateTimeFormatter);
        } else {
            return null;
        }
    }

    /**
     * 将LocalDateTime转为long类型的timestamp
     * @param localDateTime
     * @return long
     */
    public static long getTimestampOfDateTime(LocalDateTime localDateTime){
        ZoneId zoneId = ZoneId.systemDefault();
        Instant instant = localDateTime.atZone(zoneId).toInstant();
        return instant.toEpochMilli();
    }

    /**
     * 将long类型的timestamp转为LocalDateTime
     * @param timestamp
     * @return LocalDateTime
     */
    public static LocalDateTime getDateTimeOfTimestamp(long timestamp){
        Instant instant = Instant.ofEpochMilli(timestamp);
        ZoneId zoneId = ZoneId.systemDefault();
        return LocalDateTime.ofInstant(instant,zoneId);
    }

    /**
     * 判断一个日期是否在指定日期之后
     * @param data 要比较的日期
     * @param afterData 指定的日期
     * @param format 格式
     * @return boolean
     */
    public static boolean isAfter(String data , String afterData , String format){
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(format);
        LocalDateTime datas = LocalDateTime.parse(data,dateTimeFormatter);
        LocalDateTime afterDa = LocalDateTime.parse(afterData , dateTimeFormatter);
        return datas.isAfter(afterDa);
    }

    /**
     * 判断一个日期是否在指定日期之前
     * @param data 要比较的日期
     * @param before 指定的日期
     * @param format 格式
     * @return boolean
     */
    public static boolean isBefore(String data,String before ,String format){
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(format);
        LocalDateTime datas = LocalDateTime.parse(data,dateTimeFormatter);
        LocalDateTime afterDa = LocalDateTime.parse(before , dateTimeFormatter);
        return datas.isBefore(afterDa);
    }

    /**
     * 判断是否为闰年
     * @param data 日期 格式:yyyy-MM-dd
     * @return boolean
     */
    public static boolean isLeapYear(String data){
        LocalDate yeat = LocalDate.parse(data);
        return yeat.isLeapYear();
    }

    /**
     * 判断是否为闰年
     * @param localDate 日期 格式:yyyy-MM-dd
     * @return boolean
     */
    public static boolean isLeapYear(LocalDate localDate){
        return localDate.isLeapYear();
    }

    /**
     *  当前时间加减年
     * @param years 年
     * @return
     */
    public static LocalDateTime plusYears(int years){
        LocalDateTime localDateTime = LocalDateTime.now();
        return localDateTime.plusYears(years);
    }

    /**
     *  当前时间加减月
     * @param months 月份
     * @return
     */
    public static LocalDateTime plusMonths(int months){
        LocalDateTime localDateTime = LocalDateTime.now();
        return localDateTime.plusMonths(months);
    }

    /**
     *  当前时间加减日
     * @param days 日
     * @return
     */
    public static LocalDateTime plusDays(int days){
        LocalDateTime localDateTime = LocalDateTime.now();
        return localDateTime.plusDays(days);
    }

    /**
     *  当前时间加减星期
     * @param weeks 星期
     * @return
     */
    public static LocalDateTime plusWeeks(int weeks){
        LocalDateTime localDateTime = LocalDateTime.now();
        return localDateTime.plusWeeks(weeks);
    }

    /**
     * 当前时间加上几个小时，传入负数减去对应的时间
     * @param hours 时间：单位小时
     * @return LocalDateTime
     */
    public static LocalDateTime plusHours(int hours){
        LocalDateTime localDateTime = LocalDateTime.now();
        return localDateTime.plusHours(hours);
    }

    /**
     * 当前时间加上几分钟，传入负数减去对应的时间
     * @param minutes 时间：单位分钟
     * @return LocalDateTime
     */
    public static LocalDateTime plusMinutes(int minutes){
        LocalDateTime localDateTime = LocalDateTime.now();
        return localDateTime.plusMinutes(minutes);
    }

    /**
     * 当前时间加上几秒钟，传入负数减去对应的时间
     * @param seconds 时间：单位秒
     * @return LocalDateTime
     */
    public static LocalDateTime plusSeconds(int seconds){
        LocalDateTime localDateTime = LocalDateTime.now();
        return localDateTime.plusSeconds(seconds);
    }

    /**
     * 修改当前时间的小时
     * @param hour 时间：单位小时
     * @return LocalDateTime
     */
    public static LocalDateTime withHour(int hour){
        LocalDateTime localDateTime = LocalDateTime.now();
        return localDateTime.withHour(hour);
    }

    /**
     * 修改当前时间的分钟
     * @param minute 时间：单位分钟
     * @return LocalDateTime
     */
    public static LocalDateTime withMinute(int minute){
        LocalDateTime localDateTime = LocalDateTime.now();
        return localDateTime.withMinute(minute);
    }

    /**
     * 修改当前时间的秒
     * @param second 时间：单位秒
     * @return LocalDateTime
     */
    public static LocalDateTime withSecond(int second){
        LocalDateTime localDateTime = LocalDateTime.now();
        return localDateTime.withSecond(second);
    }

    /**
     * 给指定的时间加年
     * @param data 指定时间
     * @param years 要加上的年份负数为减去
     * @return LocalDateTime
     */
    public static LocalDateTime addYears(String data , int years){
        LocalDateTime localDateTime = formatStringToDate(data);
        return localDateTime.plusYears(years);
    }

    /**
     * 给指定的时间加月
     * @param data 指定时间
     * @param months 要加上的月负数为减去
     * @return LocalDateTime
     */
    public static LocalDateTime addMonths(String data , int months){
        LocalDateTime localDateTime = formatStringToDate(data);
        return localDateTime.plusMonths(months);
    }

    /**
     * 给指定的时间加日
     * @param data 指定时间
     * @param days 要加上的日负数为减去
     * @return LocalDateTime
     */
    public static LocalDateTime addDays(String data , int days){
        LocalDateTime localDateTime = formatStringToDate(data);
        return localDateTime.plusDays(days);
    }

    /**
     * 给指定的时间加星期
     * @param data 指定时间
     * @param weeks 要加上的星期负数为减去
     * @return LocalDateTime
     */
    public static LocalDateTime addWeeks(String data, int weeks){
        LocalDateTime localDateTime = formatStringToDate(data);
        return localDateTime.plusWeeks(weeks);
    }

    /**
     * 给指定时间加小时
     * @param data 指定时间
     * @param hour 要加上的小时负数为减去
     * @return LocalDateTime
     */
    public static LocalDateTime addHours(String data , int hour){
        LocalDateTime localDateTime = formatStringToDate(data);
        return localDateTime.plusHours(hour);
    }

    /**
     * 给指定时间加分钟
     * @param data 指定时间
     * @param minutes 要加上的分钟负数为减去
     * @return LocalDateTime
     */
    public static LocalDateTime addMinutes(String data , int minutes){
        LocalDateTime localDateTime = formatStringToDate(data);
        return localDateTime.plusMinutes(minutes);
    }

    /**
     * 给指定时间加秒
     * @param data 指定时间
     * @param seconds 要加上的秒负数为减去
     * @return LocalDateTime
     */
    public static LocalDateTime addSeconds(String data , int seconds){
        LocalDateTime localDateTime = formatStringToDate(data);
        return localDateTime.plusSeconds(seconds);
    }

    /**
     * 计算两个时间相差多少年，结果为负数说明前面的时间比后面的时间大
     * @param time1 时间一
     * @param time2 时间二
     * @return long
     */
    public static long minusYears(String time1 ,String time2){
        LocalDateTime localDateTime = formatStringToDate(time1);
        LocalDateTime localDateTime2 = formatStringToDate(time2);
        return ChronoUnit.YEARS.between(localDateTime,localDateTime2);
    }

    /**
     * 计算两个时间相差多少月，结果为负数说明前面的时间比后面的时间大
     * @param time1 时间一
     * @param time2 时间二
     * @return long
     */
    public static long minusMonths(String time1 ,String time2){
        LocalDateTime localDateTime = formatStringToDate(time1);
        LocalDateTime localDateTime2 = formatStringToDate(time2);
        return ChronoUnit.MONTHS.between(localDateTime,localDateTime2);
    }

    /**
     * 计算两个时间相差多少天，结果为负数说明前面的时间比后面的时间大
     * @param time1 时间一
     * @param time2 时间二
     * @return long
     */
    public static long minusDays(String time1 ,String time2){
        LocalDateTime localDateTime = formatStringToDate(time1);
        LocalDateTime localDateTime2 = formatStringToDate(time2);
        return ChronoUnit.DAYS.between(localDateTime,localDateTime2);
    }

    /**
     * 计算两个时间相差多少星期，结果为负数说明前面的时间比后面的时间大
     * @param time1 时间一
     * @param time2 时间二
     * @return long
     */
    public static long minusWeeks(String time1 ,String time2){
        LocalDateTime localDateTime = formatStringToDate(time1);
        LocalDateTime localDateTime2 = formatStringToDate(time2);
        return ChronoUnit.WEEKS.between(localDateTime,localDateTime2);
    }

    /**
     * 计算两个时间相差多少小时，结果为负数说明前面的时间比后面的时间大
     * @param time1 时间一
     * @param time2 时间二
     * @return long
     */
    public static long minusHours(String time1 ,String time2){
        LocalDateTime localDateTime = formatStringToDate(time1);
        LocalDateTime localDateTime2 = formatStringToDate(time2);
        return ChronoUnit.HOURS.between(localDateTime,localDateTime2);
    }

    /**
     * 计算两个时间相差多少分钟，结果为负数说明前面的时间比后面的时间大
     * @param time1 时间一
     * @param time2 时间二
     * @return long
     */
    public static long minusMinutes(String time1 ,String time2){
        LocalDateTime localDateTime = formatStringToDate(time1);
        LocalDateTime localDateTime2 = formatStringToDate(time2);
        return ChronoUnit.MINUTES.between(localDateTime,localDateTime2);
    }

    /**
     * 计算两个时间相差多少秒，结果为负数说明前面的时间比后面的时间大
     * @param time1 时间一
     * @param time2 时间二
     * @return long
     */
    public static long minusSeconds(String time1 ,String time2){
        LocalDateTime localDateTime = formatStringToDate(time1);
        LocalDateTime localDateTime2 = formatStringToDate(time2);
        return ChronoUnit.MINUTES.between(localDateTime,localDateTime2);
    }

    /**
     * 获取传入时间的年份
     * @param localDateTime 时间
     * @return
     */
    public static int getYear(LocalDateTime localDateTime){
        return localDateTime.getYear();
    }

    /**
     * 获取传入时间的月份
     * @param localDateTime 时间
     * @return
     */
    public static int getMonth(LocalDateTime localDateTime){
        return MyMonth.getMonth(localDateTime.getMonth().toString());
    }

    /**
     * 获取传入时间的日
     * @param localDateTime 时间
     * @return
     */
    public static int getDay(LocalDateTime localDateTime){
        return localDateTime.getDayOfMonth();
    }

    /**
     * 获取传入时间是星期几
     * @param localDateTime 时间
     * @return Integer
     */
    public static Integer getWeek(LocalDateTime localDateTime){
        return MyDayOfWeek.getDayWeek(localDateTime.getDayOfWeek().toString());
    }

    /**
     * 获取传入时间是一年中的第几天
     * @param localDateTime 时间
     * @return Integer
     */
    public static Integer getDayOfYear(LocalDateTime localDateTime){
        return localDateTime.getDayOfYear();
    }

    /**
     * 获取传入时间的时
     * @param localDateTime 时间
     * @return
     */
    public static int getHour(LocalDateTime localDateTime){
        return localDateTime.getHour();
    }


    /**
     * 获取传入时间的分
     * @param localDateTime 时间
     * @return
     */
    public static int getMinutes(LocalDateTime localDateTime){
        return localDateTime.getMinute();
    }

    /**
     * 获取传入时间的秒
     * @param localDateTime 时间
     * @return
     */
    public static int getSeconds(LocalDateTime localDateTime){
        return localDateTime.getSecond();
    }



}
