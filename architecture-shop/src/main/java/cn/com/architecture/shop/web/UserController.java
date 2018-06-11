package cn.com.architecture.shop.web;


import cn.com.architecture.shop.config.Const;
import cn.com.architecture.shop.entity.User;
import cn.com.architecture.shop.repository.UserRepository;
import cn.com.architecture.shop.result.ExceptionMsg;
import cn.com.architecture.shop.service.ItemService;
import cn.com.architecture.shop.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.List;


@Controller
@RequestMapping("/user")
public class UserController extends BaseController{

    @Resource
    UserService userService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ItemService itemService;


    @RequestMapping("/list")
    public String list(Model model) {
//        List<User> users=userService.getUserList();
//        model.addAttribute("users", users);
        User user = getUser();
        if(user!=null){
            model.addAttribute("items", user.getItems());
        }
        if(user!=null){
            model.addAttribute("funds", user.getFunds());
        }


        return "user/list";
    }

    @RequestMapping("/toAdd")
    public String toAdd() {
        return "user/userAdd";
    }

    @RequestMapping("/add")
    public String add(User user) {

        try {
            User registUser = userRepository.findByEmail(user.getEmail());
            if (null != registUser) {
                return ERROR;
                //return "redirect:/user/list";
            }
            User userNameUser = userRepository.findByUserName(user.getUserName());
            if (null != userNameUser) {
                return ERROR;
                //return "redirect:/user/list";
            }

            user.setPassword(getPwd(user.getPassword()));

            userRepository.save(user);

            getSession().setAttribute(Const.LOGIN_SESSION_KEY, user);


        } catch (Exception e) {
            logger.error("create user failed, ", e);
            return "redirect:/user/list";
        }


        userService.save(user);
        return "redirect:/user/list";
    }

    @RequestMapping("/toLogin")
    public String toLogin(User user) {
        return "user/userLogin";
    }


    @RequestMapping("/login")
    public String login(Model model,User user,HttpServletResponse response) {

        try {
            User loginUser = userRepository.findByUserNameOrEmail(user.getUserName(), user.getUserName());
            if (loginUser == null ) {
                return ERROR;
            }else if(!loginUser.getPassword().equals(getPwd(user.getPassword()))){
                return ERROR;
            }
            Cookie cookie = new Cookie(Const.LOGIN_SESSION_KEY, cookieSign(String.valueOf(loginUser.getId())));
            cookie.setMaxAge(Const.COOKIE_TIMEOUT);
            cookie.setPath("/");
            response.addCookie(cookie);
            setUser(loginUser);

            model.addAttribute("items", user.getItems());

            return "redirect:/user/list";
        } catch (Exception e) {
            logger.error("create user failed, ", e);
            return "redirect:/user/list";
        }

    }



    @RequestMapping("/toEdit")
    public String toEdit(Model model,Long id) {
        User user=userService.findUserById(id);
        model.addAttribute("user", user);
        return "user/userEdit";
    }

    @RequestMapping("/edit")
    public String edit(User user) {
        userService.edit(user);
        return "redirect:/user/list";
    }


    @RequestMapping("/delete")
    public String delete(Long id) {
        userService.delete(id);
        return "redirect:/user/list";
    }

}