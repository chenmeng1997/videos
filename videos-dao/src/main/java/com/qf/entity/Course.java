package com.qf.entity;

import java.io.Serializable;
import java.util.List;

public class Course implements Serializable {
    /*关联 Subject*/
    private Integer id;

    private String courseTitle;

    private Integer subjectId;

    private String courseDesc;

    private Subject subject;

    private List<Video> videoList;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCourseTitle() {
        return courseTitle;
    }

    public void setCourseTitle(String courseTitle) {
        this.courseTitle = courseTitle;
    }

    public Integer getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Integer subjectId) {
        this.subjectId = subjectId;
    }

    public String getCourseDesc() {
        return courseDesc;
    }

    public void setCourseDesc(String courseDesc) {
        this.courseDesc = courseDesc;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public List<Video> getVideoList() {
        return videoList;
    }

    public void setVideoList(List<Video> videoList) {
        this.videoList = videoList;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", courseTitle='" + courseTitle + '\'' +
                ", subjectId=" + subjectId +
                ", courseDesc='" + courseDesc + '\'' +
                ", subject=" + subject +
                ", videoList=" + videoList +
                '}';
    }

}