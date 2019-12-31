package com.qf.config.test;

import com.qf.entity.QueryVo;
import com.qf.entity.Speaker;
import com.qf.service.SpeakerService;
import com.qf.utils.Page;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class SpeakerServiceTest {
    SpeakerService speakerService;
    @Before
    public void init(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        speakerService = (SpeakerService) context.getBean("speakerService");
    }

    @Test
    public void addSpeaker(){
        Speaker speaker = new Speaker();
        speaker.setSpeakerName("阿万");
        speakerService.addSpeaker(speaker);
    }

    @Test
    public void delSpeaker(){
        speakerService.delSpeaker(15);
    }

    @Test
    public void updateSpeaker(){
        Speaker speaker = new Speaker();
        speaker.setSpeakerName("阿美");
        speaker.setId(15);
        speakerService.updateSpeaker(speaker);
    }

    @Test
    public void getAllSpeaker(){
        List<Speaker> speakerList = speakerService.getAllSpeaker();
        for (Speaker speaker:speakerList ) {
            System.out.println(speaker);
        }
    }

    @Test
    public void getAllSpeakerByqueryVo(){
        QueryVo queryVo = new QueryVo();
       /* queryVo.setSpeakerId("1");
        queryVo.setStart(0);
        queryVo.setRows(2);*/
        Page<Speaker> speakerList = speakerService.getAllSpeakerByqueryVo(queryVo);
        System.out.println(speakerList);
    }

    @Test
    public void getSpeakerCountByqueryVo(){
        QueryVo queryVo = new QueryVo();
//        queryVo.setSpeakerId("1");
//        queryVo.setStart(0);
//        queryVo.setRows(2);
        Integer countByqueryVo = speakerService.getSpeakerCountByqueryVo(queryVo);
        System.out.println(countByqueryVo);
    }//getCourseListById
}
