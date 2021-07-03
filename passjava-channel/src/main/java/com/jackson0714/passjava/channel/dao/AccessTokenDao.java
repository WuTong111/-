package com.jackson0714.passjava.channel.dao;

import com.jackson0714.passjava.channel.entity.AccessTokenEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 渠道-认证表
 * 
 * @author jackson0714
 * @email jackson0585@163.com
 * @date 2021-07-03 22:52:56
 */
@Mapper
public interface AccessTokenDao extends BaseMapper<AccessTokenEntity> {
	
}
