package com.atguigu.gmall.ums.service;

import com.atguigu.gmall.common.bean.PageParamVo;
import com.atguigu.gmall.common.bean.PageResultVo;
import com.atguigu.gmall.ums.entity.IntegrationHistoryEntity;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 购物积分记录表
 *
 * @author zege
 * @email zege@atguigu.com
 * @date 2020-07-17 00:28:55
 */
public interface IntegrationHistoryService extends IService<IntegrationHistoryEntity> {

    PageResultVo queryPage(PageParamVo paramVo);
}

