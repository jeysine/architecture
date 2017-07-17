package utils;

import java.util.function.Supplier;

/**
 * 时间观察类
 */
public class TimeWatcherUtils {


    public static boolean flag = true;

    /**日志名称*/
    private String logName;

    public TimeWatcherUtils(){
        this.logName = this.getClass().getSimpleName();
    }

    public TimeWatcherUtils(String logName){
        this.logName = logName;
    }

    public <T> void execute(Supplier<T> t){
        execute(t,this.logName);
    }

    public <T> T execute(Supplier<T> t,String logName){
        long starTime = System.currentTimeMillis();
        T result = t.get();
        long endTime = System.currentTimeMillis();
        if(flag){
            System.out.println(logName+":executeTime:"+(endTime-starTime));
        }
        return result;
    }

    public static void main(String args[]) throws Exception{


        TimeWatcherUtils t = new TimeWatcherUtils();

        t.execute(()->{
            try{
                int sum  = 0;
                for(int i = 0;i<1000000;i++){
                    sum+=i;
                }
                System.out.println(sum);
            }catch (Exception e){
                e.printStackTrace();
            }
            return 0;
        },"testSum");

    }

}
