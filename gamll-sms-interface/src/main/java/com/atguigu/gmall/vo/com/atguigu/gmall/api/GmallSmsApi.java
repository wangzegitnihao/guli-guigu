package com.atguigu.gmall.vo.com.atguigu.gmall.api;

import com.atguigu.gmall.common.bean.ResponseVo;
import com.atguigu.gmall.vo.SkuSaleVo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface GmallSmsApi {
    @PostMapping("sms/skubounds/sale")
    public ResponseVo<Object> saveSkuSaleInfo(@RequestBody SkuSaleVo skuSaleVo);
}
