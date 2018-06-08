package cn.com.architecture.shop.service.impl;

import cn.com.architecture.shop.entity.Item;
import cn.com.architecture.shop.entity.User;
import cn.com.architecture.shop.service.ItemService;
import cn.com.architecture.shop.service.UserItemService;
import cn.com.architecture.shop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by li on 2018/6/6.
 */


@Service
public class UserItemServiceImpl implements UserItemService{

    @Autowired
    UserService userService;

    @Autowired
    ItemService itemService;


    @Override
    public void save(Item item, User user) {

        item.getUsers().add(user);
        itemService.save(item);

    }

    @Override
    public void update(Item item, User user) {

    }
}


