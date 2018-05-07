package utils.delayQueue;

import java.util.concurrent.DelayQueue;
import java.util.function.Supplier;

/**
 * Created by lst on 2018/5/7.
 * DelayQueue的示例代码
 */
public class DelayMain {

    public static void main(String args[]){

        DelayQueue<DelayMessage> queue = new DelayQueue<>();

        DelayMessage message1 = new DelayMessage(1,System.currentTimeMillis()+10000,()->{
            System.out.println("1执行了");
            return 1;
            }
        );

        DelayMessage message2 = new DelayMessage(2,System.currentTimeMillis()+2000,()->{
            System.out.println("2执行了");
            return 2;
        }
        );

        queue.add(message1);

        queue.add(message2);

        DelayConsumer consumer = new DelayConsumer(queue);

        Thread t = new Thread(consumer);
        t.start();

    }

}
