package cn.edu.hyit.seppms.service.impl;

import cn.edu.hyit.seppms.domain.User;
import cn.edu.hyit.seppms.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class UserServiceImplTest {
    /**
     * 查询所有user
     */
    @Test
    public void selectAll(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring/beans.xml");
        UserService userService = (UserService) ac.getBean("userService");
        List<User> users = userService.selectAll();
        for (User user : users) {
            System.out.println(user.getId() + "\t" + user.getNumber() + "\t" + user.getName());
        }
    }

    /**
     * selectById
     */
    @Test
    public void selectOne(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring/beans.xml");
        UserService userService = (UserService) ac.getBean("userService");
        User user = userService.selectOne(1);
        System.out.println(user.getId() + "\t" + user.getNumber() +"\t" + user.getName() + "\t" + user.getPassword());
    }
}