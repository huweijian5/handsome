package com.junmeng.handsome.common

import com.junmeng.handsome.domain.Result
import com.junmeng.handsome.utils.ResultUtil
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
    fun  handle(request: HttpServletRequest, e: Exception): Result<Class<Exception>> {
        e.printStackTrace();
        if (e is BussinessException) {
            val ce = e
            return ResultUtil.error(ce.code, ce.message)
        }
        logger.error("系统异常:" + e.javaClass)
        return ResultUtil.error(-1, "未知错误", e.javaClass)
    }
}