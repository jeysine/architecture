package utils.akka;

/**
 * Created by li on 2017/12/16.
 */

public class TestInterFaceImpl implements TestInterFace {

    @Override
    public int test() {
        TestMain.count++;
        return 0;
    }

    @Override
    public void test1() {
        TestMain.count++;
    }
}
