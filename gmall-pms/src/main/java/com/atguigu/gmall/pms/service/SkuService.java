package com.atguigu.gmall.pms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.atguigu.gmall.common.bean.PageResultVo;
import com.atguigu.gmall.common.bean.PageParamVo;
import com.atguigu.gmall.pms.entity.SkuEntity;

import java.util.Map;

/**
 * sku信息
 *
 * @author zege
 * @email zege@atguigu.com
 * @date 2020-07-17 00:22:47
 */
public interface SkuService extends IService<SkuEntity> {

    PageResultVo queryPage(PageParamVo paramVo);
}

