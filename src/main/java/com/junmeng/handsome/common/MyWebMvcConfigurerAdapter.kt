package com.junmeng.handsome.common

import com.junmeng.handsome.interceptor.LogInterceptor
import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.InterceptorRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter

/**
 * Created by hwj on 2017/5/22.
 */

@Configuration
open class MyWebMvcConfigurerAdapter : WebMvcConfigurerAdapter() {

    override fun addInterceptors(registry: InterceptorRegistry?) {
       // super.addInterceptors(registry)
        // 多个拦截器组成一个拦截器链
        // addPathPatterns 用于添加拦截规则
        // excludePathPatterns 用户排除拦截
        registry!!.addInterceptor(LogInterceptor()).addPathPatterns("/**")
        super.addInterceptors(registry)

    }
}