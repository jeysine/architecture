package cn.com.architecture.shop.repository;

import cn.com.architecture.shop.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Long> {

    List<Item> findByNameContaining(String name);

    Item findById(long id);

    Item findByUrl(String url);

    List<Item> findAllByStatusEquals(int status);

    //Long deleteById(Long id);
}