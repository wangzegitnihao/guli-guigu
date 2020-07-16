package com.atguigu.gmall.sms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.atguigu.gmall.common.bean.PageResultVo;
import com.atguigu.gmall.common.bean.PageParamVo;
import com.atguigu.gmall.sms.entity.SpuBoundsEntity;

import java.util.Map;

/**
 * 商品spu积分设置
 *
 * @author zege
 * @email zege@atguigu.com
 * @date 2020-07-17 00:27:11
 */
public interface SpuBoundsService extends IService<SpuBoundsEntity> {

    PageResultVo queryPage(PageParamVo paramVo);
}

