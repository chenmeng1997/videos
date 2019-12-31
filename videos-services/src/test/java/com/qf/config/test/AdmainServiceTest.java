package com.qf.config.test;

import com.qf.dao.AdminDao;
import com.qf.entity.Admin;
import com.qf.service.AdminService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AdmainServiceTest {
    @Autowired
    AdminService adminService;
    @Test
    public void admaintest() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        AdminDao adminDao= (AdminDao) context.getBean("adminDao");
        System.out.println(adminDao.getAdminCount());
    }

    @Test
    public void getAdmin() {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        AdminService adminService = (AdminService) context.getBean("adminService");
        Admin admin = new Admin();
        admin.setUserName("陈孟");
        admin.setPassword("0000");
        System.out.println(adminService/*.getAdmin(admin)*/);
    }
}
