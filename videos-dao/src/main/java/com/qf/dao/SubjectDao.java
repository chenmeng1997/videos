package com.qf.dao;

import com.qf.entity.Subject;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubjectDao {
    @Select("select * from myssm.subject")
    public List<Subject> getAllSubject();
    @Select("select * from myssm.subject where subject.id=#{id}")
    public Subject getSubjectById(@Param("id") Integer id);
    public Subject getCourseListById(@Param("id") Integer id);
    @Select("select * from myssm.subject where subject.subjectName=#{subjectName}")
    public Subject getSubjectByName(@Param("subjectName") String subjectName);
}
