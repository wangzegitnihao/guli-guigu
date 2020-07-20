package com.atguigu.gmall.sms.mapper;

import com.atguigu.gmall.sms.entity.CouponEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 优惠券信息
 * 
 * @author zege
 * @email zege@atguigu.com
 * @date 2020-07-19 06:32:24
 */
@Mapper
public interface CouponMapper extends BaseMapper<CouponEntity> {
	
}
