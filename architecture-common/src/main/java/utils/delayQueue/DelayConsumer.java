package utils.delayQueue;

import java.util.concurrent.DelayQueue;

/**
 * Created by li on 2017/7/8.
 */


public class DelayConsumer implements Runnable{

    private DelayQueue<DelayMessage> queue;

    public DelayConsumer(DelayQueue<DelayMessage> queue){
        this.queue = queue;
    }

    public void run(){

        while(true){
            try {
                DelayMessage message = queue.take();
                message.doDelay();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

}
