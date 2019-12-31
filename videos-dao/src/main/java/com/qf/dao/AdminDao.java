package com.qf.dao;

import com.qf.entity.Admin;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminDao {
    public Integer getAdminCount();
    @Select("select userName,password from myssm.admin where userName=#{userName} and password=#{password}")
    public Admin getAdmin(Admin Admin);
}
