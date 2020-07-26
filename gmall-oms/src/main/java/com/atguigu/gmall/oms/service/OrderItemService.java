package com.atguigu.gmall.oms.service;

import com.atguigu.gmall.oms.entity.OrderItemEntity;
import com.atguigu.gmall.common.bean.PageParamVo;
import com.atguigu.gmall.common.bean.PageResultVo;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 订单项信息
 *
 * @author zege
 * @email zege@atguigu.com
 * @date 2020-07-17 00:25:27
 */
public interface OrderItemService extends IService<OrderItemEntity> {

    PageResultVo queryPage(PageParamVo paramVo);
}

