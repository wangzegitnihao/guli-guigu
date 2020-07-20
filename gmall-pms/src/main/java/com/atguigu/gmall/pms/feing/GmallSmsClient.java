package com.atguigu.gmall.pms.feing;

import com.atguigu.gmall.common.bean.ResponseVo;
import com.atguigu.gmall.vo.SkuSaleVo;
import com.atguigu.gmall.vo.com.atguigu.gmall.api.GmallSmsApi;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient("sms-service")
public interface GmallSmsClient extends GmallSmsApi {

}
