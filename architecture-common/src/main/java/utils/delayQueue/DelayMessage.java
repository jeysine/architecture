package utils.delayQueue;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;


/**
 * Created by li on 2017/7/8.
 * 过期时间消息实体
 */


public class DelayMessage implements Delayed{

    /**
     * 放置过期时间
     */
    private long time;

    private long uuid;

    //private Consumer consumer;

    private Supplier supplier;

    public DelayMessage(long uuid, long time, Supplier supplier){
        this.uuid = uuid;
        this.time = time;
        this.supplier = supplier;
    }

    @Override
    public int compareTo(Delayed o) {
        DelayMessage that = (DelayMessage)o;
        if(this.time > that.time){//过期时刻越靠后，越排在队尾.
            return 1;
        }else if(this.time==that.time){
            return 0;
        }else{
            return -1;
        }
    }

    public void doDelay(){
        supplier.get();
    }

    public long getUuid(){
        return uuid;
    }


    /**
     * 如果返回的数小于0代表到了执行时间
     * @param unit
     * @return
     */
    public long getDelay(TimeUnit unit) {
        return unit.convert(time-System.currentTimeMillis(), TimeUnit.NANOSECONDS);
    }

}
