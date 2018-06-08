package utils;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

/**
 * Created by jeysine on 2017/7/11.
 */
public class DateUtils {
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


}
