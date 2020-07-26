package com.atguigu.gmall.oms.service;

import com.atguigu.gmall.common.bean.PageParamVo;
import com.atguigu.gmall.common.bean.PageResultVo;
import com.atguigu.gmall.oms.entity.RefundInfoEntity;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 退款信息
 *
 * @author zege
 * @email zege@atguigu.com
 * @date 2020-07-17 00:25:27
 */
public interface RefundInfoService extends IService<RefundInfoEntity> {

    PageResultVo queryPage(PageParamVo paramVo);
}

