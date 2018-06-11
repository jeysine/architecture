package cn.com.architecture.shop.service.impl;

import cn.com.architecture.shop.entity.Fund;
import cn.com.architecture.shop.entity.User;
import cn.com.architecture.shop.service.FundService;
import cn.com.architecture.shop.service.UserFundService;
import cn.com.architecture.shop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by li on 2018/6/6.
 */


@Service
public class UserFundServiceImpl implements UserFundService{

    @Autowired
    UserService userService;

    @Autowired
    FundService fundService;


    @Override
    public void save(Fund fund, User user) {

        fundService.save(fund);
        user.getFunds().add(fund);
        userService.save(user);

    }

    @Override
    public void update(Fund fund, User user) {

        user.getFunds().add(fund);
        userService.save(user);

    }

    @Override
    public void delete(long fundId, User user) {
        user.getFunds().removeIf((i)->i.getId()==fundId);
        userService.save(user);
    }

    public void delete(Fund fund, User user) {
        user.getFunds().removeIf((i)->i.getId()==fund.getId());
        userService.save(user);

    }
}


