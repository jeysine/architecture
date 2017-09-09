import cn.com.architecture.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


/**
 * Created by li on 2017/8/23.
 */
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = {"classpath*:spring/test-svc-dubbo.xml"})
public class DubboProviderTest {

    @Autowired
    private TestService testService;

    @org.junit.Test
    public void sendMail() throws Exception {
        try {

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
