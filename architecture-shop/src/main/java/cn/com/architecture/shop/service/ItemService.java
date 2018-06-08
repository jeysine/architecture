package cn.com.architecture.shop.service;

import cn.com.architecture.shop.entity.Item;
import cn.com.architecture.shop.entity.User;

import java.util.List;

public interface ItemService {

    public List<Item> getItemList();

    public Item findItemById(long id);

    public void save(Item user);

    public void edit(Item user);

    public void delete(long id);

    //public Item findItemByUserId(long id);

}
