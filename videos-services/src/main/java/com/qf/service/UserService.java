package com.qf.service;

import com.qf.entity.User;

public interface UserService {
    public Integer getUserCount();
    public User getUserByEmailAndPwd(User user);
    public User getUserByEmail(User user);
    public Integer addUser(User user);
    public Integer updateUser(User user);
    public Integer updateUserPwd(User user);
    public Integer updateUserImg(User user);

}
