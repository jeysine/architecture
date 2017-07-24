package cn.com.architecture.service;

import cn.com.architecture.entity.User;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.UUID;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:spring/application-context.xml"})
public class UserServiceImplTest {
	@Autowired
	private UserService userService;

	@org.junit.Test
	public void save() throws Exception {
		User user = new User();
		user.setId(UUID.randomUUID().toString());
		user.setName("jeysine");
		user.setAge(23);
		user.setGender(0);
		userService.save(user);
	}

}