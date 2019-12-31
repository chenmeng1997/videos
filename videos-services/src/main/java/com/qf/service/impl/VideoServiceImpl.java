package com.qf.service.impl;

import com.qf.dao.VideoDao;
import com.qf.entity.QueryVo;
import com.qf.entity.Video;
import com.qf.service.VideoService;
import com.qf.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("videoService")
public class VideoServiceImpl implements VideoService {
    @Autowired
    VideoDao videoDao;

    public Page<Video> getAllVideo(QueryVo queryVo) {
        //查询符合条件数据总数
        Integer total = videoDao.getVideoCount(queryVo);
        //从那条开始查
        queryVo.setStart((queryVo.getPage()-1)*queryVo.getRows());
        //查询到的结果
        List<Video> videoList = videoDao.getAllVideo(queryVo);
        //封装Page
        Page<Video> videoPage = new Page<Video>();
        //查询到的数据
        videoPage.setRows(videoList);
        //当前页
        videoPage.setPage(queryVo.getPage());
        //每页显示条数
        videoPage.setSize(queryVo.getRows());
        //数据总数
        videoPage.setTotal(total);
        return videoPage;
    }

    public Integer getVideoCount(QueryVo queryVo) {
        return videoDao.getVideoCount(queryVo);
    }

    public Video getVideoById(Integer id) {
        return videoDao.getVideoById(id);
    }

    public Integer addVideo(Video video) {
        return videoDao.addVideo(video);
    }

    public Integer delVideo(Integer id) {
        return videoDao.delVideo(id);
    }

    public Integer updateVideo(Video video) {
        return videoDao.updateVideo(video);
    }
    public Integer updatePlayNumById(Video video){
        return videoDao.updatePlayNumById(video);
    }
}
