package com.atguigu.gmall.sms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.atguigu.gmall.common.bean.PageResultVo;
import com.atguigu.gmall.common.bean.PageParamVo;
import com.atguigu.gmall.sms.entity.UndoLogEntity;

import java.util.Map;

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

