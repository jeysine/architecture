package demo;

import java.util.Random;
import java.util.concurrent.*;

/**
 * Created by li on 2017/7/18.
 * Random随机函数表明,使用ThreadLocal可以有效的提高效率
 */
public class RandomDemo {

    public static final int GEN_COUNT = 10000000;

    public static final int THREAD_COUNT = 8;

    public static ExecutorService exe = Executors.newFixedThreadPool(THREAD_COUNT);

    public static Random rnd = new Random(123);

    public static ThreadLocal<Random> tRand = new ThreadLocal<Random>(){

        protected Random initialValue(){

            return new Random(123);
        }

    };


    public static class RndTask implements Callable<Long> {

        private int mode = 0;

        public RndTask(int mode){
            this.mode = mode;
        }

        public Random getRandom(){
            if(mode==0){
                return rnd;
            }else if(mode==1){
                return tRand.get();
            }else if(mode==2){
                return ThreadLocalRandom.current();
            }else{
                return null;
            }
        }

        @Override
        public Long call() throws Exception {
            long b = System.currentTimeMillis();
            for(long i = 0;i<GEN_COUNT;i++){
                getRandom().nextInt();
            }
            long e = System.currentTimeMillis();
            System.out.println(Thread.currentThread().getName()+"spend "+(e-b)+"ms");
            return e-b;
        }
    }

    public static void main(String args[]) throws Exception{
        Future<Long>[] futs = new Future[THREAD_COUNT];
        for(int i = 0;i<THREAD_COUNT;i++){
            futs[i] = exe.submit(new RndTask(0));
        }
        long totalTime = 0;
        for(int i = 0;i<THREAD_COUNT;i++){
            totalTime+=futs[i].get();
        }
        System.out.println("多线程访问同一个Random实例:"+totalTime+"ms");

        for(int i = 0;i<THREAD_COUNT;i++){
            futs[i] = exe.submit(new RndTask(1));
        }
        totalTime = 0;
        for(int i = 0;i<THREAD_COUNT;i++){
            totalTime+=futs[i].get();
        }
        System.out.println("ThreadLocal:"+totalTime+"ms");


        for(int i = 0;i<THREAD_COUNT;i++){
            futs[i] = exe.submit(new RndTask(2));
        }
        totalTime = 0;
        for(int i = 0;i<THREAD_COUNT;i++){
            totalTime+=futs[i].get();
        }
        System.out.println("ThreadLocalRandom.current():"+totalTime+"ms");


    }



}
