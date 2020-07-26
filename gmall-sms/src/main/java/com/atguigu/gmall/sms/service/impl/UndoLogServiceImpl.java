package com.atguigu.gmall.sms.service.impl;

import com.atguigu.gmall.common.bean.PageParamVo;
import com.atguigu.gmall.common.bean.PageResultVo;
import com.atguigu.gmall.sms.mapper.UndoLogMapper;
import com.atguigu.gmall.sms.service.UndoLogService;
import com.atguigu.gmall.sms.entity.UndoLogEntity;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;


@Service("undoLogService")
public class UndoLogServiceImpl extends ServiceImpl<UndoLogMapper, UndoLogEntity> implements UndoLogService {

    @Override
    public PageResultVo queryPage(PageParamVo paramVo) {
        IPage<UndoLogEntity> page = this.page(
                paramVo.getPage(),
                new QueryWrapper<UndoLogEntity>()
        );

        return new PageResultVo(page);
    }

}