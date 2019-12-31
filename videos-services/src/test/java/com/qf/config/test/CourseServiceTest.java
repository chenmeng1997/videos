package com.qf.config.test;

import com.qf.entity.QueryVo;
import com.qf.entity.Course;
import com.qf.entity.Video;
import com.qf.service.CourseService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class CourseServiceTest {
    CourseService courseService;
    @Before
    public void init(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        courseService = (CourseService) context.getBean("courseService");
    }

    @Test
    public void addCourse() {
        Course course = new Course();
        course.setCourseTitle("mmmm");
        courseService.addCourse(course);
    }

    @Test
    public void delCourse() {
        courseService.delCourse(7);
    }

    @Test
    public void updateCourse() {
        Course course = new Course();
        course.setCourseTitle("m7777mmm");
        course.setId(7);
        courseService.updateCourse(course);
    }

    @Test
    public void getAllCourse() {
        List<Course> courseList = courseService.getAllCourse();
        for (Course course:courseList) {
            System.out.println(course);
        }
    }

    @Test
    public void getAllCoursePage() {
        QueryVo queryVo = new QueryVo();
        queryVo.setStart(0);
        queryVo.setRows(3);
//        List<Course> courseList = courseService.getAllCoursePage(queryVo);
//        for (Course course:courseList) {
//            System.out.println(course);
//        }
    }

    @Test
    public void getCourseCount() {
        System.out.println( courseService.getCourseCount());
    }

    @Test
    public void getCourseById() {
        List<Video> videoList = courseService.getCourseById(2).getVideoList();
      //  System.out.println(courseService.getCourseById(1));
        for (Video video: videoList){
            System.out.println(video);
        }
    }

    @Test
    public void findAllVideoById() {
        List<Video> videoList = courseService.findAllVideoById(2).getVideoList();
        //  System.out.println(courseService.getCourseById(1));
        for (Video video: videoList){
            System.out.println(video);
        }
    }
}
