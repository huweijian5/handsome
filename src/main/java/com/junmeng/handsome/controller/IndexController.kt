package com.junmeng.handsome.controller

import com.junmeng.handsome.domain.ApiResult
import com.junmeng.handsome.entity.OperateLog
import com.junmeng.handsome.repository.OperateLogRepo
import com.junmeng.handsome.utils.ApiResultUtil
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.ui.ModelMap
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.servlet.ModelAndView

/**
 * Created by hwj on 2017/5/21.
 */
@RestController
open class IndexController {

    @Autowired
    var operateLogRepo: OperateLogRepo? = null

    @GetMapping(value= "/login")
    open fun login(model: ModelMap): ModelAndView {
         return ModelAndView("/login")
    }

    @GetMapping(value = "/log")
    open fun log(): ApiResult<List<OperateLog>> {
        var list: List<OperateLog>? = operateLogRepo?.findAll()
        return ApiResultUtil.success(list)
    }
    @GetMapping(value = "/index")
    open fun index(): ModelAndView {
        return ModelAndView("/index")
    }


}