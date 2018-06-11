package cn.com.architecture.shop.service.impl;

import cn.com.architecture.shop.config.Const;
import cn.com.architecture.shop.entity.Fund;
import cn.com.architecture.shop.repository.FundRepository;
import cn.com.architecture.shop.service.FundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FundServiceImpl implements FundService {

    @Autowired
    private FundRepository fundRepository;

    @Override
    public List<Fund> getAllFundList() {
        return fundRepository.findAll();
    }

    @Override
    public List<Fund> getNormalFundList() {
        return fundRepository.findAllByStatusEquals(Const.DataStatus.NORMAL);
    }

    @Override
    public Fund findFundById(long id) {
         return fundRepository.findById(id);
    }

    @Override
    public void save(Fund fund) {
        fundRepository.save(fund);
    }

    @Override
    public void edit(Fund fund) {
        fundRepository.save(fund);
    }

    @Override
    public void delete(long id) {
        fundRepository.deleteById(id);
    }

    @Override
    public void delete(Fund fund) {//标记状态为删除
        //fund.setStatus(1);
        fundRepository.save(fund);
    }


    @Override
    public Fund findFundByUrl(String url) {
        return fundRepository.findByUrl(url);
    }
}
