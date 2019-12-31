package com.qf.service.impl;

import com.qf.dao.AdminDao;
import com.qf.entity.Admin;
import com.qf.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("adminService")
public class AdminServiceImpl implements AdminService {
    @Autowired
    AdminDao adminDao;
    public boolean getAdmin(Admin Admin) {
        boolean flag = false;
        Admin admin1 = adminDao.getAdmin(Admin);
        if (admin1 != null){
            flag = true;
        }
        return flag;
    }
}
