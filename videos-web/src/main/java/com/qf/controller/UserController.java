package com.qf.controller;

import com.qf.entity.Subject;
import com.qf.entity.User;
import com.qf.service.SubjectService;
import com.qf.service.UserService;
import com.qf.utils.ImageCut;
import com.qf.utils.MailUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.List;
import java.util.UUID;

@RequestMapping("/user")
@Controller
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    SubjectService subjectService;

    static String validateCode;

    @RequestMapping("/index")
    public String index(Model model){
        List<Subject> subjectList = subjectService.getAllSubject();
        model.addAttribute("subjectList",subjectList);
        return "before/index";
    }

    //登录
    @RequestMapping("/loginUser")
    @ResponseBody
    public String loginUser(User user, HttpServletRequest request){
        User user1 = userService.getUserByEmailAndPwd(user);
        if(user1 != null){
            request.getSession().setAttribute("userAccount",user1.getEmail());
            request.getSession().setAttribute("user",user1);
            return "success";
        }else{
            return "error";
        }
    }

    //退出
    @RequestMapping("/loginOut2")
    public String loginOut2(HttpServletRequest request){
//        Object userAccount = request.getSession().getAttribute("userAccount");
//        System.out.println("userAccount:"+userAccount);

        request.getSession().removeAttribute("userAccount");
        return "redirect:index";
    }

    //忘记密码
    @RequestMapping("/forgetPassword")
    public String forgetPassword(User user, Model model){
        return "before/forget_password";
    }
    @RequestMapping("/sendEmail")
    @ResponseBody
    public String sendEmail(String email){
        User user = new User();
        user.setEmail(email);
        User userByEmail = userService.getUserByEmail(user);
        if (userByEmail != null){
            //邮件发送
            validateCode = MailUtils.getValidateCode(6);
            MailUtils.sendMail("2322051194@qq.com",
                    "你好,确认提交后密码将重置为：0000。你的验证码是："+ validateCode,
                    "Y先生密码重置" );
            System.out.println("validateCode:"+validateCode);
            return "success";
        }else{
            return "hasNoUser";
        }
    }
    //密码重置 提交后
    @RequestMapping("/validateEmailCode")
    public String validateEmailCode(String email, String code){
        System.out.println("前端接收code:"+code);

        if(validateCode.equals(code)){
            User user = new User();
            user.setEmail(email);
            user.setPassword("0000");
            userService.updateUserPwd(user);
            System.out.println("密码重置成功！");
        }
        return "redirect:index";
    }

    //注册 跳转到我的页面
    @RequestMapping(value = {"/insertUser"})
    @ResponseBody
    public String insertUser(User user, Model model){
        System.out.println("insertUser:"+user);
        userService.addUser(user);
        model.addAttribute("userAccount",user.getEmail());
        return "success";
    }

    //注册 邮箱检测
    @RequestMapping("/validateEmail")
    @ResponseBody
    public String validateEmail(User user, Model model){
        User user1 = userService.getUserByEmail(user);
        if (user1 != null ){
            return "error";
        }else{
            System.out.println("success");
            return "success";
        }
    }
    //显示本人信息 据email
    @RequestMapping("/showMyProfile")
    public String showMyProfile(HttpServletRequest request){
        String email =(String) request.getSession().getAttribute("userAccount");
        User user = new User();
        if(email != null){
            user.setEmail(email);
            User user1 = userService.getUserByEmail(user);
            request.setAttribute("user",user1);
        }
        //System.out.println("email: "+email);
        return "before/my_profile";
    }

    //更改资料 changeProfile
    @RequestMapping("/changeProfile")
    public String changeProfile(HttpServletRequest request, Model model){
        String email =(String) request.getSession().getAttribute("userAccount");
        User user = new User();
        if(email != null){
            user.setEmail(email);
            User user1 = userService.getUserByEmail(user);
            request.setAttribute("user",user1);
        }
        return "before/change_profile";
    }
    //改 资料
    @RequestMapping("/updateUser")
    public String updateUser(HttpServletRequest request, User user){
        String email =(String) request.getSession().getAttribute("userAccount");
        if(user != null && email!=null){
            user.setEmail(email);
            userService.updateUser(user);
        }
        return "redirect:showMyProfile";
    }
    //密码安全 passwordSafe
    @RequestMapping("/passwordSafe")
    public String passwordSafe(HttpServletRequest request, User user, Model model){
        String email =(String) request.getSession().getAttribute("userAccount");
        if(email != null){
            user.setEmail(email);
            User user1 = userService.getUserByEmail(user);
            System.out.println(user1);
            model.addAttribute("user",user1);
        }
        return "before/password_safe";
    }

    //或取旧密码 比较
    @RequestMapping("/validatePassword")
    @ResponseBody
    public String validatePassword(HttpServletRequest request, String password){
        String email =(String) request.getSession().getAttribute("userAccount");
        if(password != null && email != null){
            User user = new User();
            user.setEmail(email);
            user.setPassword(password);
            User user1 = userService.getUserByEmailAndPwd(user);
            if (user1 != null){
                return "success";
            }
        }
        return "error";
    }
    //改密
    @RequestMapping("/updatePassword")
    public String updatePassword(HttpServletRequest request, String newPassword, Model model){
        String email =(String) request.getSession().getAttribute("userAccount");
        if(email != null && newPassword != null){
            User user = new User();
            user.setEmail(email);
            user.setPassword(newPassword);
            userService.updateUserPwd(user);
            model.addAttribute("user",user);
        }
        return "redirect:showMyProfile";
    }

    //改头像
    @RequestMapping("/changeAvatar")
    public String changeAvatar(HttpServletRequest request, Model model){
        String email =(String) request.getSession().getAttribute("userAccount");
        if(email != null){
            User user = new User();
            user.setEmail(email);
            User user1 = userService.getUserByEmail(user);
            model.addAttribute("user",user1);
        }
        return "before/change_avatar";
    }
    //接收并更改 upLoadImage
    @RequestMapping("/upLoadImage")
    public String upLoadImage(@RequestParam("image_file") MultipartFile imageFile,
                              String x1, String x2, String y1, String y2,
                              HttpServletRequest request)throws Exception{
        //已获取
        System.out.println(x1+" x2:"+x2+" y1:"+y1+" y2:"+y2);

        // 上传的位置
        String path = "D:\\apache-tomcat-8.5.43-windows-x64-FILE\\apache-tomcat-8.5.43\\webapps\\uploadfile\\images";
        File file = new File(path); // 判断，该路径是否存在
        if(!file.exists()){
            file.mkdirs(); // 创建该文件夹
        }
        String filename = imageFile.getOriginalFilename(); // 获取上传文件的名称
        String uuid = UUID.randomUUID().toString().replace("-", "");
        filename = uuid+"_"+filename;
        imageFile.transferTo(new File(path,filename));// 完成文件上传
//可获取
//        System.out.println("filename："+filename);
//        System.out.println("file:"+file.toString());

        //截取图片
        if(x1 != null && x2 != null && y1 != null && y1 != null){
            int X1 = (int)Double.parseDouble(x1);
            int X2 = (int)Double.parseDouble(x2);
            int Y1 = (int)Double.parseDouble(y1);
            int Y2 = (int)Double.parseDouble(y2);
            new ImageCut().cutImage(path+"/"+filename,X1,Y1,X2-X1,Y2-Y1);
            System.out.println(X1+" "+X2+" "+Y1+" "+Y2);
        }

        //改图片
        String email =(String) request.getSession().getAttribute("userAccount");
        User user = new User();
        user.setEmail(email);
        user = userService.getUserByEmail(user);
        if(filename != null){
            user.setImgUrl(filename);
            System.out.println("filename != null:"+filename);
        }else{
            user.setImgUrl(request.getParameter("image_file"));
        }
        userService.updateUserImg(user);
      //  System.out.println("user:"+user);
        return "redirect:showMyProfile";
    }

}
