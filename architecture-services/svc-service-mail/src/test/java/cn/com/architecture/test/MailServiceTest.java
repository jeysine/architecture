package cn.com.architecture.test;

import cn.com.architecture.service.MailService;
import cn.com.architecture.service.exception.MailServiceException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:spring/application-context-test.xml"})
public class MailServiceTest {
	@Autowired
	private MailService mailService;

	@org.junit.Test
	public void sendMail() throws Exception {
		try {
			mailService.sendTextMail(Arrays.asList("test@jeysine.cn"), null,
					"No-Attachment Mail", "A mail without attachment");
		} catch (MailServiceException e) {
			e.printStackTrace();
		}
	}
}
