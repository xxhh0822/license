package com.zp.license.controller;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

/**
* @Author: license
* @Description: 拦截器配置
* @DateTime: 17:55 2022/12/9
* @Params:
* @Return
*/
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    @Resource
    private LicenseCheckInterceptor licenseCheckInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        //添加要拦截的url
        registry.addInterceptor(licenseCheckInterceptor)
                // 拦截的路径
                .addPathPatterns("/**");
                // 放行的路径
//                .excludePathPatterns("/admin/login");
    }
}
