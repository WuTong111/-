package com.jackson0714.passjava.question.dao;

import com.jackson0714.passjava.question.entity.TypeEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 题目-题目类型表
 * 
 * @author jackson0714
 * @email jackson0585@163.com
 * @date 2021-07-03 21:12:06
 */
@Mapper
public interface TypeDao extends BaseMapper<TypeEntity> {
	
}
