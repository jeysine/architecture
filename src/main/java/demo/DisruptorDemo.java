package demo;

import com.lmax.disruptor.*;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Administrator on 2017/7/21.
 */
public class DisruptorDemo {

    public static void main(String args[]){


       // ExecutorService executor = Executors.newCachedThreadPool();

        WaitStrategy BLOCKING_WAIT = new BlockingWaitStrategy();
        WaitStrategy SLEEPING_WAIT = new SleepingWaitStrategy();
        WaitStrategy YIELDING_WAIT = new YieldingWaitStrategy();


        EventFactory<LongEvent> eventFactory = new LongEventFactory();
        ExecutorService executor = Executors.newSingleThreadExecutor();
        int ringBufferSize = 1024 * 1024; // RingBuffer 大小，必须是 2 的 N 次方；

        Disruptor<LongEvent> disruptor = new Disruptor<LongEvent>(eventFactory,
                ringBufferSize, executor, ProducerType.SINGLE,
                new YieldingWaitStrategy());

        EventHandler<LongEvent> eventHandler = new LongEventHandler();
        disruptor.handleEventsWith(eventHandler);

        disruptor.start();


        final RingBuffer<LongEvent> rb1 = new RingBuffer<LongEvent>(
                new LongEventFactory(),
                new MultiThreadedClaimStrategy(2048),
                new YieldingWaitStrategy());

        final RingBuffer<LongEvent> rb2 = new RingBuffer<LongEvent>(
                new LongEventFactory(),
                new MultiThreadedClaimStrategy(2048),
                new YieldingWaitStrategy());

        EventHandler seh1 = new LongEventHandler(null);
        EventHandler seh2 = new LongEventHandler(null);
        EventHandler seh3 = new LongEventHandler(rb2);
        EventHandler seh4 = new LongEventHandler(null);
        EventHandler seh5 = new LongEventHandler(null);

        final EventHandler<LongEvent> eh1 = new LongEventHandler(seh1, seh2);
        final EventHandler<LongEvent> eh2 = new AggregateEventHandler<LongEvent>(eh1, seh3);
        final EventHandler<LongEvent> eh3 = new AggregateEventHandler<LongEvent>(seh4, seh5);

        final EventProcessor ep1 = new BatchEventProcessor<LongEvent>(
                rb1,
                rb1.newBarrier(),
                eh2);

        final EventProcessor ep2 = new BatchEventProcessor<LongEvent>(
                rb2,
                rb2.newBarrier(),
                eh3);

        rb1.setGatingSequences(ep1.getSequence());
        rb2.setGatingSequences(ep2.getSequence());

        final long start = System.currentTimeMillis();

        new Thread(ep1, "EP1").start();
        new Thread(ep2, "EP2").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                int count = 0;
                while (count < 9000000) {
                    long sequence = rb1.next();
                    LongEvent event = rb1.get(sequence);
                    event.setValue("A");
                    rb1.publish(sequence);
                    count = count + 1;
                }
                System.out.println("T" + (System.currentTimeMillis() - start));
            }
        }, "P1").start();


    }


}
