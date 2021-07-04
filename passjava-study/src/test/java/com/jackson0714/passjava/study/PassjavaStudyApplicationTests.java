package com.jackson0714.passjava.study;

import com.jackson0714.passjava.study.entity.StudyTimeEntity;
import com.jackson0714.passjava.study.service.StudyTimeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PassjavaStudyApplicationTests {
    @Autowired
    StudyTimeService studyTimeService;

    @Test
    public void contextLoads() {
        StudyTimeEntity studyTimeEntity = new StudyTimeEntity();
        studyTimeEntity.setMemberId(1001L);
        studyTimeService.save(studyTimeEntity);
    }

}
