package cn.com.architecture.dao;

import cn.com.architecture.entity.User;
import org.springframework.stereotype.Component;

@Component
public interface UserDao extends BaseDAO<User, User> {
}
