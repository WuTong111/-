package com.jackson0714.passjava.study.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jackson0714.passjava.study.entity.ViewLogEntity;
import com.jackson0714.passjava.study.service.ViewLogService;
import com.jackson0714.common.utils.PageUtils;
import com.jackson0714.common.utils.R;



/**
 * 学习-用户学习浏览记录表
 *
 * @author jackson0714
 * @email jackson0585@163.com
 * @date 2021-07-04 15:30:59
 */
@RestController
@RequestMapping("study/viewlog")
public class ViewLogController {
    @Autowired
    private ViewLogService viewLogService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = viewLogService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
		ViewLogEntity viewLog = viewLogService.getById(id);

        return R.ok().put("viewLog", viewLog);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ViewLogEntity viewLog){
		viewLogService.save(viewLog);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody ViewLogEntity viewLog){
		viewLogService.updateById(viewLog);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
		viewLogService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
