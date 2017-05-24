package com.junmeng.handsome.controller;

import org.springframework.boot.autoconfigure.web.servlet.error.ErrorController
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.servlet.ModelAndView

/**
 * 自定义错误页面
 * Created by HWJ on 2017/3/30.
 */
@Controller
open class MyErrorController : ErrorController {
    override fun getErrorPath(): String {
        return "/error"
    }

    @RequestMapping(value = "/error")
    fun handleError(): ModelAndView {
        return ModelAndView("error/404")
    }

}