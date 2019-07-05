package com.wqw.springbootjpa.repository;

import com.wqw.springbootjpa.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @Author: wangqiwei
 * @Date: 2019/7/4 11:08
 */
public interface UserRepository extends JpaRepository<User,Integer> {
   //自己定义方法实现查询
    List<User> findByName(String name);
    List<User> findByNameLike(String name);
}
