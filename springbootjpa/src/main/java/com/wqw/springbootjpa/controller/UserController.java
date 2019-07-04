package com.wqw.springbootjpa.controller;

import com.wqw.springbootjpa.pojo.User;
import com.wqw.springbootjpa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: wangqiwei
 * @Date: 2019/7/4 14:50
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    //搜索用户  /findUser?name=test
    @GetMapping("/findUser")
    public List<User> findUser(@RequestParam(value = "name")String name){
        System.out.println("name="+name);
        User user = new User();
        user.setName(name);
        Example<User> example =Example.of(user);
        return userService.getAllByOther(example);
    }

    //根据ID删除用户
    @GetMapping("/deleteUserById")
    public String deleteUserById(@RequestParam(value = "id") Integer id){
        userService.deleteUser(id);
        return "删除成功！";
    }

    // 分页显示数据
    @GetMapping("/user")
    public Page<User> showPage(@RequestParam(value = "page") Integer page, @RequestParam(value = "size") Integer size){
        System.out.println("分页： page:"+page+"; size:"+size);
        return userService.getPage(page, size);
    }
    // 排序分页显示数据
    @GetMapping("/user_sort")
    public Page<User> showSortPage(@RequestParam(value = "page") Integer page, @RequestParam(value = "size") Integer size){
        System.out.println("排序分页： page:"+page+"; size:"+size);
        return userService.getPageSort(page, size);
    }
    //不分页显示数据
    @GetMapping("/getUserAll")
    public List<User> showUserAll(){
        System.out.println("不分页显示数据");
        return userService.getUserAll();
    }

    //不分页排序显示数据
    @GetMapping("/getUserAllSort")
    public List<User> showUserAllSort(){
        System.out.println("不分页显示排序数据");
        return userService.getUsrAllSort();
    }

}
