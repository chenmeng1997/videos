package com.qf.config.test;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AdmianDao {
    @Test
    public void getAdminCount(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        AdmianDao admianDao = (AdmianDao) context.getBean("admianDao");
        System.out.println(admianDao);
        /*admianDao.getAdminCount();*/
    }
}
