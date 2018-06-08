package cn.com.architecture.shop.web;


import cn.com.architecture.shop.entity.Item;
import cn.com.architecture.shop.entity.User;
import cn.com.architecture.shop.service.ItemService;
import cn.com.architecture.shop.service.UserItemService;
import cn.com.architecture.shop.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import utils.DateUtils;

import javax.annotation.Resource;
import java.util.List;


@Controller
@RequestMapping("/item")
public class ItemController extends BaseController{

    @Resource
    ItemService itemService;

    @Resource
    UserItemService userItemService;


    @RequestMapping("/")
    public String index() {
        return "redirect:/item/list";
    }

    @RequestMapping("/list")
    public String list(Model model) {
        List<Item> items=itemService.getItemList();
        model.addAttribute("items", items);
        return "item/list";
    }

    @RequestMapping("/toAdd")
    public String toAdd() {
        return "item/itemAdd";
    }

    @RequestMapping("/add")
    public String add(Item item) {
        //User user = Session
        User user = getUser();
        if(user==null){
            //return ERROR;
            return "redirect:/user/list";
        }

        item.setPushTime(DateUtils.getCurrentTime());
        userItemService.save(item,user);

        getUser().getItems().add(item);

        return "redirect:/item/list";
    }

    @RequestMapping("/toEdit")
    public String toEdit(Model model,Long id) {
        Item item=itemService.findItemById(id);
        model.addAttribute("item", item);
        return "item/itemEdit";
    }

    @RequestMapping("/edit")
    public String edit(Item item) {
        itemService.edit(item);
        return "redirect:/item/list";
    }

    @RequestMapping("/delete")
    public String delete(Long id) {
        itemService.delete(id);
        return "redirect:/item/list";
    }
}