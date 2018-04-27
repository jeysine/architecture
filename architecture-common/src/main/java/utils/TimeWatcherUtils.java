package utils;

import utils.ssh.VoidTest;

/**
 * Created by li on 2017/7/18.
 * 时间观察类
 */
public class TimeWatcherUtils {

    private static TimeWatcherUtils instance = new TimeWatcherUtils();

    public static final int MILL = 0;//毫秒

    public static final int SEC = 1;//秒

    public static final int MINUTE = 2;//分

    private int  timeType= SEC;

    public static TimeWatcherUtils getInstance() {
        return instance;
    }

    public static boolean flag = true;

    /**日志名称*/
    private String logName;

    public void setTimeType(int timeType) {
        this.timeType = timeType;
    }

    public int getTimeType() {
        return timeType;
    }

    public void setLogName(String logName) {
        this.logName = logName;
    }

    public TimeWatcherUtils(){
        this.logName = this.getClass().getSimpleName();
    }

    public TimeWatcherUtils(String logName){
        this.logName = logName;
    }

    public  void func(VoidTest v) throws Exception{
        func(v, logName);
    }

    public  void func(VoidTest v,String logName) throws Exception{
        long starTime = System.currentTimeMillis();
        v.execFunc();
        long endTime = System.currentTimeMillis();
        if(flag){
            defaultString(logName, starTime, endTime);
        }
    }

    public void defaultString(String logName, long starTime, long endTime) {
        System.out.println("---------------------------------------------------------------------------------");
        long millTime = endTime-starTime;
        System.out.println(logName+":"+getTime(millTime));
        System.out.println("---------------------------------------------------------------------------------");
    }

    public static void main(String args[]) throws Exception{


        TimeWatcherUtils t = new TimeWatcherUtils();
        t.func(()->{sum();},"testSum");

    }

    /**
     * 获得时间
     * @param time
     * @return
     */
    public String getTime(long time){
        switch (timeType) {
            case MILL:
                return time+"milliseconds";
            case SEC:
                return (time/1000)+"seconds";
            case MINUTE:
                return (time/1000/60)+"minutes";
            default:
                return time+"milliseconds";
        }
    }

    public static void sum(){
        try{
            int sum  = 0;
            for(int i = 0;i<1000000;i++){
                sum+=i;
            }
            System.out.println(sum);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
