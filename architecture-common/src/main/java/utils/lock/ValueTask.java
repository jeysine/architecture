package utils.lock;

/**
 * Created by lst on 2018/5/7.
 */
@FunctionalInterface
public interface ValueTask<V> {

    V exec() throws Exception;
}


