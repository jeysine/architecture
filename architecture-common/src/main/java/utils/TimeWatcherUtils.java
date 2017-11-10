package utils;

/**
 * Created by li on 2017/7/18.
 * 时间观察类
 */
public class TimeWatcherUtils {

    private static TimeWatcherUtils instance = new TimeWatcherUtils();

    public static TimeWatcherUtils getInstance() {
        return instance;
    }

    public static boolean flag = true;

    /**日志名称*/
    private String logName;

    public void setLogName(String logName) {
        this.logName = logName;
    }

    public TimeWatcherUtils(){
        this.logName = this.getClass().getSimpleName();
    }

    public TimeWatcherUtils(String logName){
        this.logName = logName;
    }

//    public <T> void execute(Supplier<T> t){
//        execute(t,this.logName);
//    }
//
//    public <T> T execute(Supplier<T> t,String logName){
//        long starTime = System.currentTimeMillis();
//        T result = t.get();
//        long endTime = System.currentTimeMillis();
//        if(flag){
//            System.out.println(logName+":executeTime:"+(endTime-starTime));
//        }
//        return result;
//    }

    public  void func(VoidTest v) throws Exception{
        func(v, logName);
    }

    public  void func(VoidTest v,String logName) throws Exception{
        long starTime = System.currentTimeMillis();
        v.execFunc();
        long endTime = System.currentTimeMillis();
        if(flag){
            System.out.println(logName+":executeTime:"+(endTime-starTime));
        }
    }

    public static void main(String args[]) throws Exception{


        TimeWatcherUtils t = new TimeWatcherUtils();

//        t.execute(()->{
//            try{
//                int sum  = 0;
//                for(int i = 0;i<1000000;i++){
//                    sum+=i;
//                }
//                System.out.println(sum);
//            }catch (Exception e){
//                e.printStackTrace();
//            }
//            return 0;
//        },"testSum");

        t.func(()->{sum();},"testSum");

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
