package cn.com.architecture.shop.service;

import cn.com.architecture.shop.entity.Item;
import cn.com.architecture.shop.entity.User;

import java.util.List;

public interface ItemService {

    public List<Item> getAllItemList();

    public List<Item> getNormalItemList();

    public Item findItemById(long id);

    public void save(Item item);

    public void edit(Item item);

    public void delete(long id);

    public void delete(Item item);

    public Item findItemByUrl(String url);

}
