package com.atguigu.gmall.ums.service;

import com.atguigu.gmall.common.bean.PageParamVo;
import com.atguigu.gmall.common.bean.PageResultVo;
import com.atguigu.gmall.ums.entity.UserCollectSubjectEntity;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 关注活动表
 *
 * @author zege
 * @email zege@atguigu.com
 * @date 2020-07-17 00:28:54
 */
public interface UserCollectSubjectService extends IService<UserCollectSubjectEntity> {

    PageResultVo queryPage(PageParamVo paramVo);
}

