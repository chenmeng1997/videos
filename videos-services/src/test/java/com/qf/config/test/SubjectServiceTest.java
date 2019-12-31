package com.qf.config.test;

import com.qf.service.SubjectService;
import com.qf.entity.Subject;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SubjectServiceTest {
    SubjectService subjectService;
    @Before
    public void init(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        subjectService = (SubjectService) context.getBean("subjectService");
    }
    @Test
    public void getCourseListById(){
       Subject subject= subjectService.getCourseListById(1);
        subject.getCourseList();
        System.out.println(subject.getCourseList().toString());
    }
}
