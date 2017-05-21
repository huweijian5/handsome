package com.junmeng.handsome.controller;

import org.springframework.ui.ModelMap
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.servlet.ModelAndView

/**
 * 自定义错误页面
 * Created by HWJ on 2017/3/30.
 */
@RestController
@RequestMapping("error")
class ErrorController {


    @GetMapping(value = "/401")
    fun handle401Error(model: ModelMap): ModelAndView {
        return ModelAndView("error/401")
    }

    @GetMapping(value = "/404")
    fun handle404Error(model: ModelMap): ModelAndView {
        return ModelAndView("error/404")
    }

    @GetMapping(value = "/500")
    fun handle500Error(model: ModelMap): ModelAndView {
        return ModelAndView("error/500")
    }

}