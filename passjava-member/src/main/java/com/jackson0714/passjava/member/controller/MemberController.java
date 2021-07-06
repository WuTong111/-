package com.jackson0714.passjava.member.controller;

import java.util.Arrays;
import java.util.Map;

import com.jackson0714.passjava.member.feign.StudyTimeFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jackson0714.passjava.member.entity.MemberEntity;
import com.jackson0714.passjava.member.service.MemberService;
import com.jackson0714.common.utils.PageUtils;
import com.jackson0714.common.utils.R;

import javax.annotation.Resource;


/**
 * 会员-会员表
 *
 * @author jackson0714
 * @email jackson0585@163.com
 * @date 2021-07-04 15:40:01
 */
@RefreshScope       //动态刷新nacos配置
@RestController
@RequestMapping("member/member")
public class MemberController {
    private final MemberService memberService;

    @Value("${member.nickname}")
    private String nickname;

    @Value("${member.age}")
    private Integer age;

    @Resource
    private StudyTimeFeignService studyTimeFeignService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @RequestMapping("/test-local-config")
    public R testLocalConfig(){
        return R.ok().put("nickName", nickname).put("age", age);
    }

    @RequestMapping("/studytime/list/test/{id}")
    public R getMemberStudyTimeListTest(@PathVariable("id") Long id){
        //mock数据库查到的会员信息
        MemberEntity memberEntity = new MemberEntity();
        memberEntity.setId(100L); // 学习时长：100分钟
        memberEntity.setNickname("可乐小屋");

        R memberStudyTimeList = studyTimeFeignService.getMemberStudyTimeListTest(id);
        return R.ok().put("member",memberEntity)
                    .put("studytime", memberStudyTimeList);

    }
    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = memberService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
		MemberEntity member = memberService.getById(id);

        return R.ok().put("member", member);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody MemberEntity member){
		memberService.save(member);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody MemberEntity member){
		memberService.updateById(member);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
		memberService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
