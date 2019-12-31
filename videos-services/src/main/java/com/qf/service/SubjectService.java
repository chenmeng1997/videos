package com.qf.service;

import com.qf.entity.Subject;

import java.util.List;

public interface SubjectService {
    public List<Subject> getAllSubject();
    public Subject getSubjectById(Integer id);
    public Subject getCourseListById(Integer id);
    public Subject getSubjectByName(String subjectName);
}
