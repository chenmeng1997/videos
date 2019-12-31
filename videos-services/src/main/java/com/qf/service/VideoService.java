package com.qf.service;


import com.qf.entity.QueryVo;
import com.qf.entity.Video;
import com.qf.utils.Page;

public interface VideoService {
    //分页模糊查找
    public Page<Video> getAllVideo(QueryVo queryVo);
    //分页模糊查找，数据总数
    public Integer getVideoCount(QueryVo queryVo);
    //按ID查询
    public Video getVideoById(Integer id);
    //添加
    public Integer addVideo(Video video);
    //删
    public Integer delVideo(Integer id);
    //改
    public Integer updateVideo(Video video);
    //播放次数更新
    public Integer updatePlayNumById(Video video);

}
