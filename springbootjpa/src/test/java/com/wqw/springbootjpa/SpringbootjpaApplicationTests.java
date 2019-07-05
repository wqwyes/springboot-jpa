package com.wqw.springbootjpa;

import com.wqw.springbootjpa.pojo.User;
import com.wqw.springbootjpa.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootjpaApplicationTests {

    @Autowired
    UserRepository userRepository;

    @Test
    public void contextLoads() {
    }

    @Test
    public void testFindAll(){
        List<User> users = userRepository.findAll();
        System.out.println("users' size is :" + users.size());
    }

    @Test
    public void testFindUserByOther(){
        User user = new User();
        user.setName("test");
        Example<User> example =Example.of(user);
        List<User> users = userRepository.findAll(example);
        for(int i = 0 ; i < users.size() ;i++){
            System.out.println("user[" + i+"]"+" info is:"+users.get(i).toString());
        }
    }

    @Test
    public void testdeleteUseById(){
        Integer id = 3;
        userRepository.deleteById(3);
    }

    @Test
    public void findByName(){
        System.out.println(userRepository.findByName("zhangsan").size());
    }

    @Test
    public void findByNameLike(){
        System.out.println(userRepository.findByNameLike("test").size());
    }
    @Test
    public void testHello(){
        System.out.println("hello");
    }
}
