package com.qf.config.test;

import com.qf.dao.UserDao;
import com.qf.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserServiceTest {
    UserService userService;
    UserDao userDao;
    @Before
    public void init(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        userService = (UserService) context.getBean("userService");
        userDao = (UserDao) context.getBean("userDao");
    }

    @Test
    public void test(){

    }
}
