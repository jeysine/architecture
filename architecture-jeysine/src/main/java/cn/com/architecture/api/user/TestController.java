package cn.com.architecture.api.user;

import cn.com.architecture.entity.ApiResult;
import cn.com.architecture.entity.User;
import cn.com.architecture.service.TestService;
import cn.com.architecture.service.UserService;
import cn.com.architecture.service.test.entity.TestEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import utils.UuidUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.UUID;

@RestController
@RequestMapping(value = { "/test" }, produces = "application/json")
public class TestController {


    @Autowired
    TestService testService;

    @Autowired
    private UserService userService;
//    @RequestMapping(value = "/", method = RequestMethod.GET)
//    public ResponseEntity<ApiResult> login(HttpServletRequest request) {
//        return new ResponseEntity<>(ApiResult.success(), HttpStatus.OK);
//    }



    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<User> test(HttpServletRequest request) {
        User user = new User();
        user.setAge(27);
        user.setGender(1);
        user.setId(UuidUtils.getUUID());
        userService.save(user);
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }
}
