package cn.com.architecture.repo;

import cn.com.architecture.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}
