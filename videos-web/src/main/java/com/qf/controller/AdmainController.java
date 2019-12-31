package com.qf.controller;

import com.qf.entity.Admin;
import com.qf.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("/admin")
public class AdmainController {
    @Autowired
    AdminService adminService;

    @RequestMapping("/tologin")
    public String toLogin(){
        return "behind/login";
    }

    @RequestMapping("/login")
    public void Login(Admin admin, HttpServletResponse response, HttpServletRequest request){
        System.out.println(admin);
        if(adminService.getAdmin(admin)){
            try {
                response.getWriter().print("success");
                request.getSession().setAttribute("userName",admin.getUserName());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @RequestMapping("/exit")
    public String exit(HttpServletRequest request) {
        request.getSession().removeAttribute("userName");
        return "redirect:tologin";
    }
}
