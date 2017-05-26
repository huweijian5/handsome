package com.junmeng.handsome.common

import com.junmeng.handsome.domain.ApiResult
import com.junmeng.handsome.utils.ApiResultUtil
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ResponseBody
import javax.servlet.http.HttpServletRequest


/**
 * 异常处理器，捕获所有异常，并按照统一格式返回
 * Created by hwj on 2017/5/21.
 */
@ControllerAdvice
class ExceptionHandler {
    val logger = LoggerFactory.getLogger(this.javaClass)

    @org.springframework.web.bind.annotation.ExceptionHandler(value = Exception::class)
    @ResponseBody
    fun  handle(request: HttpServletRequest, e: Exception): ApiResult<Class<Exception>> {
        e.printStackTrace();
        if (e is BussinessException) {
            val ce = e
            return ApiResultUtil.error(ce.code, ce.message)
        }
        logger.error("系统异常:" + e.javaClass)
        return ApiResultUtil.error(-1, "未知错误", e.javaClass)
    }
}