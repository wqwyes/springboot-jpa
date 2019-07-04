package com.wqw.springbootjpa.repository;

import com.wqw.springbootjpa.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author: wangqiwei
 * @Date: 2019/7/4 11:08
 */
public interface UserRepository extends JpaRepository<User,Integer> {
}
