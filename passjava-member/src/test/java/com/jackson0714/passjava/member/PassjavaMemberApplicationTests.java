package com.jackson0714.passjava.member;

import com.jackson0714.passjava.member.entity.MemberEntity;
import com.jackson0714.passjava.member.service.MemberService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PassjavaMemberApplicationTests {
    @Autowired
    MemberService memberService;

    @Test
    public void contextLoads() {
        MemberEntity memberEntity = new MemberEntity();
        memberEntity.setNickname("测试案例");
        memberService.save(memberEntity);
    }

}
