package com.atguigu.gmall.sms.service;

import com.atguigu.gmall.common.bean.PageParamVo;
import com.atguigu.gmall.common.bean.PageResultVo;
import com.atguigu.gmall.sms.entity.UndoLogEntity;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 
 *
 * @author zege
 * @email zege@atguigu.com
 * @date 2020-07-19 06:32:24
 */
public interface UndoLogService extends IService<UndoLogEntity> {

    PageResultVo queryPage(PageParamVo paramVo);
}

