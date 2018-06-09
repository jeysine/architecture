package utils;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by jeysine on 2017/7/11.
 */
public class DateUtils {

    /** 毫秒:1秒 */
    public static final long MS = 1000L; //毫秒:1秒
    /** 秒:一分钟 */
    public static final long TOTAL_SEC_PER_MINUTE = 60; //秒:一分钟
    /** 秒:一小时 */
    public static final long TOTAL_SEC_PER_HOUR = 60L*TOTAL_SEC_PER_MINUTE;//秒:一小时
    /** 秒:一天 */
    public static final long TOTAL_SEC_PER_DAY = 24L*TOTAL_SEC_PER_HOUR;//秒:一天
    /** 毫秒:一天 */
    public static final long TOTAL_MS_PER_DAY = 24L*TOTAL_SEC_PER_HOUR*MS;//毫秒:一天
    /** 毫秒:一周 */
    public static final long TOTAL_MS_PER_WEEK = 7L*24*TOTAL_SEC_PER_HOUR*MS;//毫秒:一周

    /** yyyy-MM-dd */
    public static final String DATE_PATTERN = "yyyy-MM-dd";
    /** yyyy-MM-dd HH:mm:ss */
    public static final String TIME_PATTERN = "yyyy-MM-dd HH:mm:ss";
    /** yyyyMMdd */
    public static final String DATE_PATTERN1 = "yyyyMMdd";
    /** yyyyMMddHHmmss */
    public static final String TIME_PATTERN1 = "yyyyMMddHHmmss";


    public static LocalDateTime add(LocalDateTime date,ChronoUnit part , int value) {
        return date.plus(value, part);
    }

    public static String format(LocalDateTime date) {
        return date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }
    public static String format(LocalDateTime date, DateTimeFormatter formatter) {
        return date.format(formatter);
    }

    public static Instant format(Long epochMilli) {
        return Instant.ofEpochMilli(epochMilli);
    }

    public static String getDateInChinese(LocalDateTime date) {
        return date.format(DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH:mm:ss"));
    }

    /**
     * 字符转换为日期。
     *
     * @param source
     * @return
     */
    public static LocalDateTime stringToDate(String source) {
        return stringToDate(source, "yyyy-MM-dd HH:mm:ss", null);
    }

    /**
     * 字符转换为日期。
     *
     * @param source
     * @param pattern
     *            日期格式串如yyyy-MM-dd HH:mm:ss
     * @return
     */
    public static LocalDateTime stringToDate(String source, String pattern) {
        return stringToDate(source, pattern, null);
    }

    /**
     * 字符串转换为指定时区时间
     *
     * @param value
     * @param pattern
     *            如yyyy-MM-dd HH:mm:ss
     * @param timeZone
     *            如东八区GMT +8
     * @return
     */
    public static LocalDateTime stringToDate(String value, String pattern, String timeZone) {
        timeZone = timeZone == null ? ZoneId.systemDefault().toString() : timeZone;
        //LocalDateTime date = LocalDateTime.parse(value,DateTimeFormatter.ofPattern(pattern));
        ZoneId zoneId = ZoneId.of(timeZone);
        ZonedDateTime date = ZonedDateTime.parse(value, DateTimeFormatter.ofPattern(pattern));


        return date.toLocalDateTime();
    }
    public static void main(String[] args) {
        System.out.println("============ 时间运算 ===========");
        System.out.println("两天后：" +
                DateUtils.add(LocalDateTime.now(), ChronoUnit.DAYS, 2));
        System.out.println("两小时后：" +
                DateUtils.add(LocalDateTime.now(), ChronoUnit.HOURS, 2));
        System.out.println("两分钟前：" +
                DateUtils.add(LocalDateTime.now(), ChronoUnit.MINUTES, -2));
        System.out.println("两个月前：" +
                DateUtils.add(LocalDateTime.now(), ChronoUnit.MONTHS, -2));

        System.out.println("=========== 日期格式化 ===========");
        System.out.println(DateUtils.format(LocalDateTime.now()));
        System.out.println(DateUtils.getDateInChinese(LocalDateTime.now()));
        //System.out.println(DateUtils.format(LocalDateTime.now(),DateTimeFormatter));
        System.out.println(Instant.now().toEpochMilli());
        System.out.println(LocalDateTime.parse(LocalDateTime.now().toString(),DateTimeFormatter.ISO_LOCAL_TIME));
        //System.out.println(DateUtils.stringToDate("2016-02-14T18:32:04.150Z"));
    }

    public static long getCurrentTime() {
        return System.currentTimeMillis();
    }


    /**
     * 判断两个时间是否处于同一天
     * @author chenzl
     * @param time1 -- 判断的时间1
     * @param time2 -- 判断的时间2
     * @param hour -- 重置的小时  ： 24小时制 1-24
     * @return true：处于同一天
     */
    public static boolean isSameDay(long time1, long time2, int hour) {
        long zero1 = truncate(new Date(time1)).getTime() + hour * TOTAL_SEC_PER_HOUR * MS;//第一个零点时间
        if(zero1 > time1){
            zero1 = zero1 - 24 * TOTAL_SEC_PER_HOUR * MS;
        }

        long zero2 = truncate(new Date(time2)).getTime() + hour * TOTAL_SEC_PER_HOUR * MS;//第一个零点时间
        if(zero2 > time2){
            zero2 = zero2 - 24 * TOTAL_SEC_PER_HOUR * MS;
        }

        if(zero1 == zero2){
            return true;
        }

        return false;
    }

    /**
     * 截取时间，去掉时分秒
     * <pre>
     * DateUtil.truncate(new Date()) = Wed Nov 04 00:00:00 CST 2015
     * </pre>
     * @param date
     * @return
     */
    public static Date truncate(Date date){
        Calendar cal = new GregorianCalendar();
        cal.setTime(date);

        // Reset all time to zero
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);

        return cal.getTime();
    }


}
