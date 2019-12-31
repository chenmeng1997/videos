package com.qf.controller;

import com.qf.service.SubjectService;
import com.qf.entity.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/subjec")
public class SubjectController {
    @Autowired
    SubjectService subjectService;
    @RequestMapping("/subjectList")
    public String subjectList(Model model){
        List<Subject> subjectList = subjectService.getAllSubject();
        model.addAttribute("subjectList",subjectList);
        return "before/index";
    }
}
