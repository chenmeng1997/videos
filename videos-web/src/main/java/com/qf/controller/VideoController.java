package com.qf.controller;

import com.qf.entity.*;
import com.qf.service.CourseService;
import com.qf.service.SpeakerService;
import com.qf.service.SubjectService;
import com.qf.utils.Page;
import com.qf.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/video")
public class VideoController {
    @Autowired
    VideoService videoService;
    @Autowired
    SpeakerService speakerService;
    @Autowired
    CourseService courseService;
    @Autowired
    SubjectService subjectService;

    //模糊查询 分页
    @RequestMapping("/list")
    public String getAllVideo(Model model, QueryVo queryVo){

        List<Speaker> speakerList = speakerService.getAllSpeaker();
        List<Course> courseList = courseService.getAllCourse();
        Page<Video> page = videoService.getAllVideo(queryVo);

        model.addAttribute("speakerList",speakerList);
        model.addAttribute("courseList",courseList);
        model.addAttribute("page",page);
        return "behind/videoList";
    }

    //跳转到修改页面
    @RequestMapping(value = {"/addVideo", "/edit"})
    public String addVideo(Video video, Model model){
        Integer videoId = video.getId();
        //回显video数据
        if(videoId != null && !videoId.equals("")){
            Video video1 = videoService.getVideoById(videoId);
            model.addAttribute("video",video1);
        }
        //下拉框
        List<Speaker> speakerList = speakerService.getAllSpeaker();
        List<Course> courseList = courseService.getAllCourse();
        model.addAttribute("speakerList",speakerList);
        model.addAttribute("courseList",courseList);
        return "behind/addVideo";
    }
    //添加 修改
    @RequestMapping("saveOrUpdate")
    public String saveOrUpdate(Video video, Model model){
        Integer videoId = video.getId();
        Video video1 = null;
        //添加 修改
        if(videoId == null || videoId.equals("")){
            videoService.addVideo(video);
        }else{
            videoService.updateVideo(video);
        }
        return "redirect:list";
    }

    //更新播放次数
    @RequestMapping("/updatePlayNum")//id playNum
    public void updatePlayNum(Video video){
        video.setPlayNum(video.getPlayNum()+1);
        videoService.updatePlayNumById(video);
    }

    @RequestMapping("/videoDel")
    @ResponseBody//将返回值作为字符串 返回给回调函数
    //删除
    public String videoDel(Integer id){
        if(id != null ){
            videoService.delVideo(id);
            return "success";
        }else {
            return "failed";
        }
    }

    @RequestMapping("/delBatchVideos")
    //批量删除
    public String delBatchVideos(Integer[] ids){
        if(ids.length>0) {
            for (Integer id : ids) {
                videoService.delVideo(id);
            }
        }
        return "redirect:list";
    }

    @RequestMapping("/showVideo")
    public String showVideo(Model model, String subjectName, String videoId){
        //Subject
        List<Subject> subjectList = subjectService.getAllSubject();
        Subject subject = subjectService.getSubjectByName(subjectName);
        //video
        Video video = videoService.getVideoById(Integer.parseInt(videoId));
        videoService.updatePlayNumById(video);
        //course
        Course course = courseService.findAllVideoById(video.getCourseId());
        //System.out.println("VideoList: "+course.getVideoList());

        model.addAttribute("subjectList",subjectList);
        model.addAttribute("subjectName",subjectName);
        model.addAttribute("video",video);
        model.addAttribute("course",course);
        return "before/section";
    }
}
