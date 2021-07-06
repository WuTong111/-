package com.jackson0714.passjava.channel.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jackson0714.passjava.channel.entity.ChannelEntity;
import com.jackson0714.passjava.channel.service.ChannelService;
import com.jackson0714.common.utils.PageUtils;
import com.jackson0714.common.utils.R;



/**
 * 渠道-渠道表
 *
 * @author jackson0714
 * @email jackson0585@163.com
 * @date 2021-07-03 22:52:56
 */
@RefreshScope
@RestController
@RequestMapping("channel/channel")
public class ChannelController {
    @Autowired
    private ChannelService channelService;

    @Value("${channel.nickname}")
    private String nickName;

    @Value("${channel.url}")
    private String url;

    @RequestMapping("/sample/config")
    public R testConfig(){
        return R.ok().put("channel.nickname", nickName).put("channel.url",url);
    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params) throws Exception {
        PageUtils page = channelService.queryPage(params);
        throw new Exception("test");
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
		ChannelEntity channel = channelService.getById(id);

        return R.ok().put("channel", channel);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@Validated @RequestBody ChannelEntity channel){
		channelService.save(channel);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody ChannelEntity channel){
		channelService.updateById(channel);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
		channelService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
