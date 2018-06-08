package cn.com.architecture.shop.service.impl;

import cn.com.architecture.shop.entity.Item;
import cn.com.architecture.shop.repository.ItemRepository;
import cn.com.architecture.shop.service.ItemService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemRepository itemRepository;

    @Override
    public List<Item> getItemList() {
        return itemRepository.findAll();
    }

    @Override
    public Item findItemById(long id) {
         return itemRepository.findById(id);
    }

    @Override
    public void save(Item item) {
        itemRepository.save(item);
    }

    @Override
    public void edit(Item item) {
        itemRepository.save(item);
    }

    @Override
    public void delete(long id) {
        itemRepository.deleteById(id);
    }
}
