package com.jackson0714.passjava.question.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.jackson0714.passjava.question.entity.TypeEntity;
import com.jackson0714.passjava.question.service.TypeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class PassJavaQuestionTest {

    @Autowired
    TypeService typeService;

    @Test
    public void saveType(){
        TypeEntity typeEntity = new TypeEntity();
        typeEntity.setType("javaBasic");
        typeService.save(typeEntity);
        System.out.println("保存成功");
    }

    @Test
    public void updateType(){
        TypeEntity typeEntity = new TypeEntity();
        typeEntity.setId(1L);
        typeEntity.setType("jvm");
        typeService.save(typeEntity);
        System.out.println("修改成功");
    }

    @Test
    public void selectType(){
        List<TypeEntity> list = typeService.list();
        list.forEach(System.out::println);
        System.out.println("查询成功");
    }

    @Test
    public void removeType(){
        typeService.removeById(1L);
        System.out.println("删除成功");
    }
}