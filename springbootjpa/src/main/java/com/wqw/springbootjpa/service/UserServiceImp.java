package com.wqw.springbootjpa.service;

import com.wqw.springbootjpa.pojo.User;
import com.wqw.springbootjpa.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: wangqiwei
 * @Date: 2019/7/4 14:47
 */
@Service
public class UserServiceImp implements UserService {
    @Autowired
    UserRepository userRepository;

    @Override
    public List<User> getAllByOther(Example example) {
        List<User> users = userRepository.findAll(example);
        return users;
    }

    @Override
    public Page<User> getPage(Integer pageNum, Integer pageLimit) {
        Pageable pageable =new PageRequest(pageNum - 1,pageLimit);
        return userRepository.findAll(pageable);
    }

    @Override
    public Page<User> getPageSort(Integer pageNum, Integer pageLimit) {
        Sort sort = new Sort(Sort.Direction.DESC,"old");
        Pageable pageable =new PageRequest(pageNum - 1, pageLimit, sort);
        return userRepository.findAll(pageable);
    }

    @Override
    public List<User> getUserAll() {
        return userRepository.findAll();
    }

    @Override
    public List<User> getUsrAllSort() {
        Sort sort = new Sort(Sort.Direction.DESC,"old");
        return userRepository.findAll(sort);
    }

    @Override
    public void deleteUser(Integer id) {
        User user = new User();
        user.setId(id);
        List<User> users = new ArrayList<>();
        users.add(user);
        userRepository.deleteInBatch(users);
    }
}
