package com.wqw.springbootjpa.service;

import com.wqw.springbootjpa.pojo.User;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * @Author: wangqiwei
 * @Date: 2019/7/4 14:47
 */
public interface UserService {
    //根据信息搜索用户
    List<User> getAllByOther(Example example);

    // 普通分页
    Page<User> getPage(Integer pageNum, Integer pageLimit);

    // 排序分页
    Page<User> getPageSort(Integer pageNum, Integer pageLimit);

    //JpaRepository类中List<T> findAll();
    List<User> getUserAll();

    //JpaRepository类中List<T> findAll(Sort sort);
    List<User> getUsrAllSort();

    //根据ID删除用户,此方法繁琐
    void deleteUser(Integer id);

    //根据ID删除用户
    void deleteUserById(Integer id);

    //保存用户
    void savaUser(User user);

    //自定义方法：通过name查找user
    List<User> findByName(String name);

    //自定义方法：通过name包含字查找user
    List<User> findByNameLike(String name);

    //自定义SQL，update user
    Integer modifyUserNameById(String userName,Integer id);


}
