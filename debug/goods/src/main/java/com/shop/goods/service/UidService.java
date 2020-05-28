//package com.shop.goods.service;
//
//import com.shop.common.annotation.ResponseDecode;
//import com.shop.common.exception.FallbackException;
//import com.shop.common.configuration.MyFeignConfiguration;
////import com.shop.goods.service.impl.UidFallbackService;
//import com.shop.goods.service.impl.UidFallbackService;
//import org.springframework.aop.framework.AopContext;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.cloud.openfeign.FeignClient;
//import org.springframework.stereotype.Component;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//
//@FeignClient(value = "uid", configuration = MyFeignConfiguration.class,fallback = UidFallbackService.class)
//public interface UidService {
//
//    @GetMapping("/")
//    @ResponseDecode
//    Object getUid() throws FallbackException;
//}
