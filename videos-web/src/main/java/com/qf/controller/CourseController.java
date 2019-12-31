package com.qf.controller;

import com.qf.entity.Course;
import com.qf.entity.QueryVo;
import com.qf.entity.Subject;
import com.qf.service.CourseService;
import com.qf.service.SubjectService;
import com.qf.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/course")
public class CourseController {
    @Autowired
    CourseService courseService;
    @Autowired
    SubjectService subjectService;
    @RequestMapping("/showCourseList")
    //分页查找
    public String showCourseList(QueryVo queryVo, Model model){
        List<Subject> subjectList = subjectService.getAllSubject();
        Page<Course> page = courseService.getAllCoursePage(queryVo);
        model.addAttribute("page",page);
        model.addAttribute("subjectList",subjectList);
        return "behind/courseList";
    }
    //到修改页面
    @RequestMapping(value = {"/addCourse","/edit"})
    public String addOrSave(Integer id, Model model){
        //下拉列表
        List<Subject> subjectList = subjectService.getAllSubject();
        model.addAttribute("subjectList",subjectList);
        if(id !=null){
            //回显course
            Course course = courseService.getCourseById(id);
            model.addAttribute("course",course);
            Subject subject = course.getSubject();
            model.addAttribute("subjectName",subject.getSubjectName());
          //  System.out.println(subject);
        }
        return "behind/addCourse";
    }
    @RequestMapping("/saveOrUpdate")
    public String saveOrUpdate(Course course){
        Integer courseId = course.getId();
        if(courseId != null){
            courseService.updateCourse(course);
        }else{
            courseService.addCourse(course);
        }
        return "redirect:showCourseList";
    }

    @RequestMapping("/courseDel")
    @ResponseBody
    public String courseDel(Integer id){
        if(id != null){
            courseService.delCourse(id);
            return "success";
        }else{
            return "error";
        }
    }

    @RequestMapping(value = "/course/{subjectId}")
    public String MyCourse(@PathVariable("subjectId") Integer id, Model Model){

        //System.out.println(id);
        //course/
        Subject subject = subjectService.getSubjectById(id);
        Subject subject1 = subjectService.getCourseListById(id);

        Model.addAttribute("subject",subject1);
        System.out.println(subject.getCourseList());

        //遍历 subject
        List<Subject> subjectList = subjectService.getAllSubject();
        Model.addAttribute("subjectList",subjectList);
        return "before/course";
    }
}
