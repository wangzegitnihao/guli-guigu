package com.atguigu.gmall.oms.service.impl;

import com.atguigu.gmall.oms.entity.OrderReturnReasonEntity;
import com.atguigu.gmall.oms.mapper.OrderReturnReasonMapper;
import com.atguigu.gmall.oms.service.OrderReturnReasonService;
import com.atguigu.gmall.common.bean.PageParamVo;
import com.atguigu.gmall.common.bean.PageResultVo;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;


@Service("orderReturnReasonService")
public class OrderReturnReasonServiceImpl extends ServiceImpl<OrderReturnReasonMapper, OrderReturnReasonEntity> implements OrderReturnReasonService {

    @Override
    public PageResultVo queryPage(PageParamVo paramVo) {
        IPage<OrderReturnReasonEntity> page = this.page(
                paramVo.getPage(),
                new QueryWrapper<OrderReturnReasonEntity>()
        );

        return new PageResultVo(page);
    }

}