package utils.akka.typedactor;

/**
 * Created by li on 2017/12/16.
 */

public class TestInterFaceImpl implements TestInterFace {

    @Override
    public int test() {//同步调用
        TestMain.count++;
        return 0;
    }

    @Override
    public void test1() {//异步调用,无返回值
        TestMain.count++;
    }
}
