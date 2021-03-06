package com.atguigu.gmall.wms.service.impl;

import com.atguigu.gmall.wms.entity.PurchaseEntity;
import com.atguigu.gmall.wms.mapper.PurchaseMapper;
import com.atguigu.gmall.wms.service.PurchaseService;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.atguigu.gmall.common.bean.PageResultVo;
import com.atguigu.gmall.common.bean.PageParamVo;


@Service("purchaseService")
public class PurchaseServiceImpl extends ServiceImpl<PurchaseMapper, PurchaseEntity> implements PurchaseService {

    @Override
    public PageResultVo queryPage(PageParamVo paramVo) {
        IPage<PurchaseEntity> page = this.page(
                paramVo.getPage(),
                new QueryWrapper<PurchaseEntity>()
        );

        return new PageResultVo(page);
    }

}