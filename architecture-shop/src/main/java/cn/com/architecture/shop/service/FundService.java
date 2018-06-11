package cn.com.architecture.shop.service;

import cn.com.architecture.shop.entity.Fund;

import java.util.List;

public interface FundService {

    public List<Fund> getAllFundList();

    public List<Fund> getNormalFundList();

    public Fund findFundById(long id);

    public void save(Fund fund);

    public void edit(Fund fund);

    public void delete(long id);

    public void delete(Fund fund);

    public Fund findFundByUrl(String url);

}
