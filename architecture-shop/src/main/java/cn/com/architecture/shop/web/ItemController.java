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
        List<Item> items=itemService.getNormalItemList();
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

        Item dbItem = itemService.findItemByUrl(item.getUrl());

        try{
            if(dbItem==null){
                userItemService.save(item,user);
            }else{
                dbItem.setStatus(0);
                userItemService.update(dbItem,user);
            }
            //getUser().getItems().add(item);
        }catch (Exception e){
            logger.error("订阅物品失败,",e);
        }


        return "redirect:/user/list";
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
        return "redirect:/user/list";
    }

    @RequestMapping("/delete")
    public String delete(Long id) {
        itemService.delete(id);
        return "redirect:/item/list";
    }

    @RequestMapping("/userDelete")
    public String userDelete(Long id) {
        try{
            userItemService.delete(id,getUser());
        }catch (Exception e){
            e.printStackTrace();
        }
        return "redirect:/user/list";
    }
}