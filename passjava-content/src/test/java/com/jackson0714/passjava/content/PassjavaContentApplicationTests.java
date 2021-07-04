package com.jackson0714.passjava.content;

import com.jackson0714.passjava.content.entity.BannerEntity;
import com.jackson0714.passjava.content.service.BannerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PassjavaContentApplicationTests {

    @Autowired
    BannerService bannerService;
    @Test
    public void contextLoads() {
        BannerEntity bannerEntity = new BannerEntity();
        bannerEntity.setTitle("测试案例");
        bannerService.save(bannerEntity);
    }

}
