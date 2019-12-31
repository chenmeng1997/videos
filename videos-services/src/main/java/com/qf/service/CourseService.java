package com.qf.service;

import com.qf.entity.QueryVo;
import com.qf.entity.Course;
import com.qf.utils.Page;

import java.util.List;

public interface CourseService {
    /*增*/
    public Integer addCourse(Course course);
    /*删*/
    public Integer delCourse(Integer id);
    /*改*/
    public Integer updateCourse(Course course);
    /*查所有*/
    public List<Course> getAllCourse();
    /*分页查询*/
    public Page<Course> getAllCoursePage(QueryVo queryVo);
    /*查询符合条件数据总数*/
    public Integer getCourseCount();
    /*据id查*/
    public Course getCourseById(Integer id);
    public Course findAllVideoById(Integer id);

}
