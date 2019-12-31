package com.qf.config.test;

import com.qf.entity.QueryVo;
import com.qf.entity.Video;
import com.qf.service.VideoService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class VideoServiceTest {
    VideoService videoService;
    @Before
    public void init(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        videoService= (VideoService) context.getBean("videoService");
    }
    @Test
    public void getVideoCount(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        VideoService videoService = (VideoService) context.getBean("videoService");
        QueryVo queryVo = new QueryVo();
        queryVo.setSpeakerId("7");
        queryVo.setCourseId("6");
        Integer count = videoService.getVideoCount(queryVo);
        System.out.println(count);

    }
    @Test
    public void getAllVideo(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        VideoService videoService = (VideoService) context.getBean("videoService");
        QueryVo queryVo = new QueryVo();
        queryVo.setSpeakerId("7");
        queryVo.setCourseId("6");
      /*  List<Video> videoList = videoService.getAllVideo(queryVo);

        for (Video video: videoList){
            System.out.println(video);
        }*/
    }

    @Test
    public void getVideoById(){
        Video video = videoService.getVideoById(2);
        System.out.println(video);
    }

    @Test
    public void InsertVideo(){
        Video video = new Video();
        video.setTitle("1111111111 259");
        Integer result = videoService.addVideo(video);
        System.out.println(result);
    }

    @Test
    public void updateVideo(){
        Video video = new Video();
        video.setTitle("11111122222");
        video.setId(259);
        Integer result = videoService.updateVideo(video);
        System.out.println(result);
    }
    @Test
    public void delVideo(){
        Integer result = videoService.delVideo(259);
        System.out.println(result);
    }

}
