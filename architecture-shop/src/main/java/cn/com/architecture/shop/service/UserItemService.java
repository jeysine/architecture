package cn.com.architecture.shop.service;

import cn.com.architecture.shop.entity.Item;
import cn.com.architecture.shop.entity.User;

/**
 * Created by li on 2018/6/6.
 */

public interface UserItemService {

    public void save(Item item, User user);


    public void update(Item item,User user);


}
