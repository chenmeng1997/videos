package com.qf.dao;

import com.qf.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao {
    @Select("select count(1) from myssm.user")
    public Integer getUserCount();
    //查 找邮箱sh是否存在
    @Select("select * from myssm.user where email=#{email}")
    public User getUserByEmail(User user);
    //查 据email password查找用户
    @Select("select email,password from myssm.user where email=#{email} and password=#{password}")
    public User getUserByEmailAndPwd(User user);
    //增 注册
    @Insert("insert into myssm.user(email, password) values (#{email},#{password})")
    public Integer addUser(User user);
    //改
    public Integer updateUser(User user);
    //改密码
    public Integer updateUserPwd(User user);
    //改图片
    public Integer updateUserImg(User user);
}
