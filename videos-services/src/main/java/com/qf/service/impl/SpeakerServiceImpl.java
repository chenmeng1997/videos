package com.qf.service.impl;

import com.qf.dao.SpeakerDao;
import com.qf.entity.QueryVo;
import com.qf.entity.Speaker;
import com.qf.service.SpeakerService;
import com.qf.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("speakerService")
public class SpeakerServiceImpl implements SpeakerService {
    @Autowired
    SpeakerDao speakerDao;

    public Integer addSpeaker(Speaker speaker) {
        return speakerDao.addSpeaker(speaker);
    }

    public Integer delSpeaker(Integer id) {
        return speakerDao.delSpeaker(id);
    }

    public Integer updateSpeaker(Speaker speaker) {
        return speakerDao.updateSpeaker(speaker);
    }

    public Speaker getSpeakerById(Integer id){
        Speaker speaker = speakerDao.getSpeakerById(id);
        return speaker;
    }

    public List<Speaker> getAllSpeaker() {
        return speakerDao.getAllSpeaker();
    }

    public Page<Speaker> getAllSpeakerByqueryVo(QueryVo queryVo) {
        //总条数
        Integer total = speakerDao.getSpeakerCountByqueryVo(queryVo);
        //起始位置
        queryVo.setStart((queryVo.getPage()-1)*queryVo.getRows());
        //查询结果
        List<Speaker> speakerList = speakerDao.getAllSpeakerByqueryVo(queryVo);
        //分装对象
        Page<Speaker> page = new Page<Speaker>();
        //封装结果
        page.setRows(speakerList);
        //当前页
        page.setPage(queryVo.getPage());
        //每页显示数据条数
        page.setSize(queryVo.getRows());
        //数据总数
        page.setTotal(total);

        return page;
    }

    public Integer getSpeakerCountByqueryVo(QueryVo queryVo) {
        return speakerDao.getSpeakerCountByqueryVo(queryVo);
    }
}
