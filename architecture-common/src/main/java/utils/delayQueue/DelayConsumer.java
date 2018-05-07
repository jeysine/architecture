package utils.delayQueue;

import java.util.concurrent.DelayQueue;

/**
 * Created by li on 2017/7/8.
 */


public class DelayConsumer implements Runnable{

    private DelayQueue<DelayMessage> queue;

    private long time = 0;

    public DelayConsumer(DelayQueue<DelayMessage> queue){
        this.queue = queue;
    }

    public void run(){
        long t = System.currentTimeMillis();
        while(true){
            try {
                DelayMessage message = queue.take();
                message.doDelay();
                long end = System.currentTimeMillis();
                time = end-t+time;
                t = end;
                System.out.println("消息Id:"+message.getUuid()+"在:"+(time/1000)+"秒的时候执行了");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

}
