package com.atguigu.gmall.pms.service.impl;

import com.atguigu.gmall.pms.entity.BrandEntity;
import com.atguigu.gmall.pms.mapper.BrandMapper;
import com.atguigu.gmall.pms.service.BrandService;
import com.atguigu.gmall.common.bean.PageParamVo;
import com.atguigu.gmall.common.bean.PageResultVo;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;


@Service("brandService")
public class BrandServiceImpl extends ServiceImpl<BrandMapper, BrandEntity> implements BrandService {

    @Override
    public PageResultVo queryPage(PageParamVo paramVo) {
        IPage<BrandEntity> page = this.page(
                paramVo.getPage(),
                new QueryWrapper<BrandEntity>()
        );

        return new PageResultVo(page);
    }

}