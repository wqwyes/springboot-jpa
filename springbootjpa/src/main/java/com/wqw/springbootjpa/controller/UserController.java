package com.wqw.springbootjpa.controller;

import com.wqw.springbootjpa.pojo.User;
import com.wqw.springbootjpa.repository.UserRepository;
import com.wqw.springbootjpa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

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

    //根据ID删除用户,此方法繁琐
    @GetMapping("/deleteUser")
    public String deleteUser(@RequestParam(value = "id") Integer id){
        userService.deleteUser(id);
        return "删除成功！";
    }

    //根据ID删除用户
    @GetMapping("/deleteUserById")
    public String deleteUserById(@RequestParam(value = "id") Integer id){
        userService.deleteUserById(id);
        return "删除成功";
    }

    //保存用户
    @PostMapping("/saveUser")
    public String saveUser(@RequestBody User user){
        userService.savaUser(user);
        return "保存成功！";
    }

    //自定义方法：通过name查找用户
    @GetMapping("/findUserByName")
    public List<User> findByName(@RequestParam(value = "name") String name){
        return userService.findByName(name);
    }

    //自定义方法：通过name关键字查找用户
    @GetMapping("/findUserByNameLike")
    public List<User> findByNameLike(@RequestParam(value = "name") String name){
        return userService.findByNameLike(name);
    }

    //自定义SQL，update user
    @GetMapping("/updateUserName")
    public Integer modifyUserNameById(@RequestParam(value = "userName") String userName, @RequestParam("id") Integer id){
        return userService.modifyUserNameById(userName,id);
    }
}
