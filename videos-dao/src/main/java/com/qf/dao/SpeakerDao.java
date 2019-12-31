package com.qf.dao;

import com.qf.entity.QueryVo;
import com.qf.entity.Speaker;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface SpeakerDao {
    /*增*/
    public Integer addSpeaker(Speaker speaker);
    /*删*/
    @Delete("delete from myssm.speaker where id=#{id}")
    public Integer delSpeaker(@Param("id") Integer id);
    /*改*/
    public Integer updateSpeaker(Speaker speaker);
    /*据ID查*/
    @Select("select * from myssm.speaker where speaker.id=#{id}")
    public Speaker getSpeakerById(@Param("id")Integer id);
    /*查所有*/
    @Select("select * from myssm.speaker")
    public List<Speaker> getAllSpeaker();
    /*分页查询*/
    public List<Speaker> getAllSpeakerByqueryVo(QueryVo queryVo);
    /*据条件获取数据总数*/
    public Integer getSpeakerCountByqueryVo(QueryVo queryVo);

}
