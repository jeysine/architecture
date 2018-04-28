package utils.akka.typedactor;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

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
                    inter.test();
                    //inter.test1(); //异步调用,要得到正确的值,在countDownLatch.await();后面需要增加线程休眠时间
                }
                countDownLatch.countDown();
            });
        }

        countDownLatch.await();

        //Thread.sleep(1000);增加线程休眠时间

        System.out.println("是否线程安全?"+(threadCount*time==count));

        System.out.println(count);

        AkkaContext.stopTypedActor(inter);

        exe.shutdown();

        AkkaContext.system().terminate();//在老旧的版本里是shutdown


    }


}
