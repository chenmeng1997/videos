package com.qf.dao;

import com.qf.entity.QueryVo;
import com.qf.entity.Course;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseDao {
    /*增*/
    public Integer addCourse(Course course);
    /*删*/
    @Delete("delete from myssm.course where id=#{id}")
    public Integer delCourse(@Param("id") Integer id);
    /*改*/
    public Integer updateCourse(Course course);
    /*查所有*/
    @Select("select * from myssm.course")
    public List<Course> getAllCourse();
    /*分页查询*/
    public List<Course> getAllCoursePage(QueryVo queryVo);
    /*查询符合条件数据总数*/
    public Integer getCourseCount();
    /*据id查*/
    public Course getCourseById(@Param("id") Integer id);
    /*据ID查 findAllCourseVideo*/
    public Course findAllVideoById(@Param("id") Integer id);
}
