package com.qf.service.impl;

import com.qf.dao.UserDao;
import com.qf.entity.User;
import com.qf.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;
    public Integer getUserCount() {
        return userDao.getUserCount();
    }
    //查找
    public User getUserByEmailAndPwd(User user) {
        return userDao.getUserByEmailAndPwd(user);
    }
    //查找邮箱
    public User getUserByEmail(User user){
        User user1=null;
        if(user != null){
            user1 = userDao.getUserByEmail(user);
        }
        return user1;
    }
    //增 注册
    public Integer addUser(User user){
        return userDao.addUser(user);
    }
    //改 据email
    public Integer updateUser(User user){
        return userDao.updateUser(user);
    }
    //改秘码 据email
    public Integer updateUserPwd(User user){
        return userDao.updateUserPwd(user);
    }
    //改图片路径
    public Integer updateUserImg(User user){
        return userDao.updateUserImg(user);
    }


}
