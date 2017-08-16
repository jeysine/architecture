package cn.com.architecture.service;


import cn.com.architecture.constants.EventConstant;
import cn.com.architecture.entity.User;
import cn.com.architecture.entity.Event;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import utils.UuidUtils;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:spring/application-context.xml"})
public class UserServiceImplTest {
	@Autowired
	private UserService userService;

	@Autowired
	private EventService eventService;

	@org.junit.Test
	public void save() throws Exception {
		UuidUtils uuidUtils = new UuidUtils();
		User user = new User();
		user.setId(uuidUtils.nextValue());
		user.setName("jeysine");
		user.setAge(23);
		user.setGender(0);
		userService.save(user);

		Event event = new Event();
		event.addProperty("userId", user.getId());
		event.setType(EventConstant.TEST.getValue());
		eventService.publish(event);
	}

}