package com.qf.dao;

import com.qf.entity.QueryVo;
import com.qf.entity.Video;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface VideoDao {
    //分页模糊查找
    public List<Video> getAllVideo(QueryVo queryVo);
    //分页模糊查找，数据总数
    public Integer getVideoCount(QueryVo queryVo);
    //按ID查询
    public Video getVideoById(@Param("id") Integer id);
    //添加
    public Integer addVideo(Video video);
    //删
    @Delete("delete from video where id=#{id}")
    public Integer delVideo(@Param("id") Integer id);
    //改
    public Integer updateVideo(Video video);
    //更新 播放次数
    @Update("update myssm.video set playNum=#{playNum} where video.id=#{id}")
    public Integer updatePlayNumById(Video video);
}
