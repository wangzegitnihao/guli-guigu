package com.atguigu.gmall.sms.service;

import com.atguigu.gmall.common.bean.PageParamVo;
import com.atguigu.gmall.common.bean.PageResultVo;
import com.atguigu.gmall.sms.entity.HomeAdvEntity;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 首页轮播广告
 *
 * @author zege
 * @email zege@atguigu.com
 * @date 2020-07-19 06:32:24
 */
public interface HomeAdvService extends IService<HomeAdvEntity> {

    PageResultVo queryPage(PageParamVo paramVo);
}

