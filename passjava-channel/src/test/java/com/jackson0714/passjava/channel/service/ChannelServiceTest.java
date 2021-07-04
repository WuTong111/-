package com.jackson0714.passjava.channel.service;


import com.jackson0714.passjava.channel.entity.ChannelEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ChannelServiceTest {
    @Autowired
    ChannelService channelService;
    @Test
    public void addChannel(){
        ChannelEntity channelEntity = new ChannelEntity();
        channelEntity.setName("渠道测试");
        channelService.save(channelEntity);
        System.out.println("保存成功");
    }

    @Test
    public void queryChannel(){
        List<ChannelEntity> list = channelService.list();
        list.forEach(System.out::println);
    }

}