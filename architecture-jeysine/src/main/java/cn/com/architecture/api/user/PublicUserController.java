package cn.com.architecture.api.user;

import cn.com.architecture.entity.ApiResult;
import cn.com.architecture.service.notification.NotificationSenderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

@RestController
@RequestMapping(value = { "/architecture/public/user" }, produces = "application/json")
public class PublicUserController {
    private Logger logger = LoggerFactory.getLogger(PublicUserController.class);
    @Autowired
    private NotificationSenderService notificationSenderService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<ApiResult> login(HttpServletRequest request) {
        logger.debug("user login");
        notificationSenderService.sendToMail(Arrays.asList("test@jeysine.cn"), null,
                "No-Attachment Mail", "A mail without attachment", null);
        return new ResponseEntity<>(ApiResult.success(), HttpStatus.OK);
    }
}
