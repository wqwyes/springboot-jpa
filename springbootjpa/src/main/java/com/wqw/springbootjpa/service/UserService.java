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

    //根据ID删除用户
    void deleteUser(Integer id);
}
