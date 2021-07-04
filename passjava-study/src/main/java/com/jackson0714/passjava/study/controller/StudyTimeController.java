package com.jackson0714.passjava.study.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jackson0714.passjava.study.entity.StudyTimeEntity;
import com.jackson0714.passjava.study.service.StudyTimeService;
import com.jackson0714.common.utils.PageUtils;
import com.jackson0714.common.utils.R;



/**
 * 学习-用户学习时常表
 *
 * @author jackson0714
 * @email jackson0585@163.com
 * @date 2021-07-04 15:30:59
 */
@RestController
@RequestMapping("study/studytime")
public class StudyTimeController {
    @Autowired
    private StudyTimeService studyTimeService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = studyTimeService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
		StudyTimeEntity studyTime = studyTimeService.getById(id);

        return R.ok().put("studyTime", studyTime);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody StudyTimeEntity studyTime){
		studyTimeService.save(studyTime);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody StudyTimeEntity studyTime){
		studyTimeService.updateById(studyTime);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
		studyTimeService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
