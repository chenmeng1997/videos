package com.qf.controller;

import com.qf.entity.QueryVo;
import com.qf.entity.Speaker;
import com.qf.service.SpeakerService;
import com.qf.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("/speaker")
public class SpeakerController {
    @Autowired
    SpeakerService speakerService;
    //模糊查询 分页
    @RequestMapping("/showSpeakerList")
    public String speakerList(Model model, QueryVo queryVo){
        Page<Speaker> page = speakerService.getAllSpeakerByqueryVo(queryVo);
        model.addAttribute("page",page);
        return "behind/speakerList";
    }
    //跳转到添加页面
    @RequestMapping(value = {"/addSpeaker","/edit"})
    public String addSpeaker(Speaker speaker, Model model){
        Integer speakerId = speaker.getId();
        if(speakerId != null){
            Speaker speaker1 = speakerService.getSpeakerById(speakerId);
            model.addAttribute("speaker",speaker1);
        }
        return "behind/addSpeaker";
    }
    //添加 修改
    @RequestMapping("/saveOrUpdate")
    public String saveOrUpdate(Speaker speaker){
        Integer speakerId = speaker.getId();
        if(speakerId != null){
            speakerService.updateSpeaker(speaker);
        }else{
            speakerService.addSpeaker(speaker);
        }
        return "redirect:showSpeakerList";
    }
    //删除
    @RequestMapping("/speakerDel")
    public void speakerDel(Integer id, HttpServletResponse response){
        if(id != null) {
            speakerService.delSpeaker(id);
            try {
                response.getWriter().print("success");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else{
            try {
                response.getWriter().print("error");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
