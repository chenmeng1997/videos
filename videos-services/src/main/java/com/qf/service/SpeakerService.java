package com.qf.service;

import com.qf.entity.QueryVo;
import com.qf.entity.Speaker;
import com.qf.utils.Page;

import java.util.List;

public interface SpeakerService {
    /*增*/
    public Integer addSpeaker(Speaker speaker);
    /*删*/
    public Integer delSpeaker(Integer id);
    /*改*/
    public Integer updateSpeaker(Speaker speaker);
    /*据ID查*/
    public Speaker getSpeakerById(Integer id);
    /*查所有*/
    public List<Speaker> getAllSpeaker();
    /*分页查询*/
    public Page<Speaker> getAllSpeakerByqueryVo(QueryVo queryVo);
    /*据条件获取数据总数*/
    public Integer getSpeakerCountByqueryVo(QueryVo queryVo);
}
