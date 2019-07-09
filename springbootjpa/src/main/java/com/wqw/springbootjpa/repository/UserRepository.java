package com.wqw.springbootjpa.repository;

import com.wqw.springbootjpa.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author: wangqiwei
 * @Date: 2019/7/4 11:08
 */
public interface UserRepository extends JpaRepository<User,Integer> {
   //自己定义方法实现查询
    List<User> findByName(String name);
    List<User> findByNameLike(String name);

    //自定义SQL，删除指定user
    @Transactional(timeout = 10)
    @Modifying
    @Query("delete from User where id = ?1")
    void deleteUserById(Integer id);

    //自定义SQL，根据名字查询
    @Query("SELECT u from User u where u.name= ?1")
    List<User> getUserByName(String name);

    //自定义SQL，修改userName
    @Transactional(timeout = 10)
    @Modifying
    @Query("update User u set u.name= ?1 where u.id= ?2")
    Integer modifyByUserId(String userName,Integer id);

}
