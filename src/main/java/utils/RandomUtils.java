package utils;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by li on 2017/7/18.
 * random工具类
 */

public class RandomUtils {

    public static int nextInt() {
        return ThreadLocalRandom.current().nextInt();
    }

    public static int nextInt(int n) {
        return ThreadLocalRandom.current().nextInt(n);
    }

    /**
     * 指定范围内随机一个整数，包含origin，不包含bound
     *
     * @param origin
     * @param bound
     * @return
     */
    public static int nextInt(int origin, int bound) {
        return ThreadLocalRandom.current().nextInt(origin, bound);
    }

    public static void main(String args[]) {



        System.out.println(nextInt(3, 20));
    }

}
