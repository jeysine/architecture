package cn.com.architecture.service.impl;

import cn.com.architecture.dao.UserDao;
import cn.com.architecture.entity.User;
import cn.com.architecture.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao dao;

	@Override
	public void insert(User entity) {
		dao.insert(entity);
	}

	@Override
	public User findById(String id) {
		return dao.findById(id);
	}

	@Override
	public void delete(String id) {
		dao.delete(id);
	}

	@Override
	public List<User> findAll() {
		return userRepository.findAll();
	}

	@Override
	public long count() {
		return userRepository.count();
	}

	@Override
	public boolean exists(String s) {
		return userRepository.exists(s);
	}
}
