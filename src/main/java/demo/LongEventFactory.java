package demo;

/**
 * Created by Administrator on 2017/7/21.
 */
import com.lmax.disruptor.EventFactory;

public class LongEventFactory implements EventFactory<LongEvent>
{
    public LongEvent newInstance()
    {
        return new LongEvent();
    }
}