package com.atguigu.gmall.oms.mapper;

import com.atguigu.gmall.oms.entity.OrderEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 订单
 * 
 * @author zege
 * @email zege@atguigu.com
 * @date 2020-07-17 00:25:27
 */
@Mapper
public interface OrderMapper extends BaseMapper<OrderEntity> {
	
}
