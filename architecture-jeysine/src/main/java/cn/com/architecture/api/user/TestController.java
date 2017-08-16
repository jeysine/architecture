package cn.com.architecture.api.user;

import cn.com.architecture.entity.ApiResult;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(value = { "/test" }, produces = "application/json")
public class TestController {
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<ApiResult> login(HttpServletRequest request) {

        return new ResponseEntity<>(ApiResult.success(), HttpStatus.OK);
    }
}
