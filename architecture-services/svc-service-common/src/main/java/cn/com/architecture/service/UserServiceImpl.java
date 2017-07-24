package cn.com.architecture.service;

import cn.com.architecture.entity.User;
import cn.com.architecture.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserRepository userRepository;

	@Override
	public User save(User entity) {
		return userRepository.save(entity);
	}

	@Override
	public User findById(String id) {
		return userRepository.findOne(id);
	}

	@Override
	public void delete(String s) {
		userRepository.delete(s);
	}

	@Override
	public Iterable<User> findAll() {
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
