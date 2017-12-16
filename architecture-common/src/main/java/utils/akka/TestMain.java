package utils.akka;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Created by li on 2017/12/16.
 */

public class TestMain {

    public static long count = 0;//计数器

    public static int threadCount = 4;//线程数量

    public static ExecutorService exe = Executors.newFixedThreadPool(threadCount);//线程池

    public static CountDownLatch countDownLatch = new CountDownLatch(threadCount);//开关

    public static int time = 1000;//计数器运行次数

    public static void main(String args[]) throws Exception{

        TestInterFace inter = AkkaContext.createTypedActor(TestInterFace.class,TestInterFaceImpl.class);

        for(int j =0;j<threadCount;j++){
            exe.submit(() ->{

                for(int i = 0;i<time;i++){
                    inter.test1();
                }
                countDownLatch.countDown();
            });
        }

        countDownLatch.await();

        System.out.println("是否线程安全?"+(threadCount*time==count));

        System.out.println(count);

        AkkaContext.stopTypedActor(inter);

        exe.shutdown();

        AkkaContext.system().shutdown();


    }


}
