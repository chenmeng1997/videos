package com.qf.service.impl;

import com.qf.service.SubjectService;
import com.qf.dao.SubjectDao;
import com.qf.entity.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("subjectService")
public class SubjectServiceImpl implements SubjectService {
    @Autowired
    SubjectDao subjectDao;
    public List<Subject> getAllSubject() {
        return subjectDao.getAllSubject();
    }
    public Subject getSubjectById(Integer id){
        return subjectDao.getSubjectById(id);
    }

    public Subject getCourseListById(Integer id){
        return subjectDao.getCourseListById(id);
    }

    public Subject getSubjectByName(String subjectName) {
        return subjectDao.getSubjectByName(subjectName);
    }

}
