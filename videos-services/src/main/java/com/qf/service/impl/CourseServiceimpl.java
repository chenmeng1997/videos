package com.qf.service.impl;

import com.qf.dao.CourseDao;
import com.qf.entity.QueryVo;
import com.qf.entity.Course;
import com.qf.service.CourseService;
import com.qf.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("courseService")
public class CourseServiceimpl implements CourseService {
    @Autowired
    CourseDao courseDao;

    public Integer addCourse(Course course) {
        return courseDao.addCourse(course);
    }

    public Integer delCourse(Integer id) {
        return courseDao.delCourse(id);
    }

    public Integer updateCourse(Course course) {
        return courseDao.updateCourse(course);
    }

    public List<Course> getAllCourse() {
        return courseDao.getAllCourse();
    }

    public Page<Course> getAllCoursePage(QueryVo queryVo) {
        //总条数
        Integer total = courseDao.getCourseCount();
        //起始位置
        queryVo.setStart((queryVo.getPage()-1)*queryVo.getRows());
        //查询结果
        List<Course> speakerList = courseDao.getAllCoursePage(queryVo);
        //分装对象
        Page<Course> page = new Page<Course>();
        //封装结果
        page.setRows(speakerList);
        //当前页
        page.setPage(queryVo.getPage());
        //每页显示数据条数
        page.setSize(queryVo.getRows());
        //数据总数
        page.setTotal(total);

        return page;
    }

    public Integer getCourseCount() {
        return courseDao.getCourseCount();
    }

    public Course getCourseById(Integer id) {
        return courseDao.getCourseById(id);
    }
    public Course findAllVideoById(Integer id){
        return courseDao.findAllVideoById(id);
    }

}
