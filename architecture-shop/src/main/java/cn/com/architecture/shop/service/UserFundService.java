package cn.com.architecture.shop.service;

import cn.com.architecture.shop.entity.Fund;
import cn.com.architecture.shop.entity.User;

/**
 * Created by li on 2018/6/6.
 */

public interface UserFundService {

    public void save(Fund fund, User user);


    public void update(Fund fund, User user);

    public void delete(long fundId, User user);


}
