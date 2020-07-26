package com.atguigu.gmall.oms.service.impl;

import com.atguigu.gmall.oms.mapper.PaymentInfoMapper;
import com.atguigu.gmall.oms.service.PaymentInfoService;
import com.atguigu.gmall.common.bean.PageParamVo;
import com.atguigu.gmall.common.bean.PageResultVo;
import com.atguigu.gmall.oms.entity.PaymentInfoEntity;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;


@Service("paymentInfoService")
public class PaymentInfoServiceImpl extends ServiceImpl<PaymentInfoMapper, PaymentInfoEntity> implements PaymentInfoService {

    @Override
    public PageResultVo queryPage(PageParamVo paramVo) {
        IPage<PaymentInfoEntity> page = this.page(
                paramVo.getPage(),
                new QueryWrapper<PaymentInfoEntity>()
        );

        return new PageResultVo(page);
    }

}