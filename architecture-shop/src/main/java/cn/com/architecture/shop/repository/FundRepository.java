package cn.com.architecture.shop.repository;

import cn.com.architecture.shop.entity.Fund;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FundRepository extends JpaRepository<Fund, Long> {

    List<Fund> findByNameContaining(String name);

    Fund findById(long id);

    Fund findByUrl(String url);

    List<Fund> findAllByStatusEquals(int status);

    //Long deleteById(Long id);
}