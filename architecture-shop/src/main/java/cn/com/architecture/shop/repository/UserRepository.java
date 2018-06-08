package cn.com.architecture.shop.repository;

import cn.com.architecture.shop.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface UserRepository extends JpaRepository<User, Long> {

    User findById(long id);

    User findByUserName(String userName);

    User findByUserNameOrEmail(String username, String email);

    User findByEmail(String email);

    @Modifying(clearAutomatically=true)
    @Transactional
    @Query("update User set passWord=:passWord where email=:email")
    int setNewPassword(@Param("passWord") String passWord, @Param("email") String email);

    //Long deleteById(Long id);
}