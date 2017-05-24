package com.junmeng.handsome.controller

import com.junmeng.handsome.domain.Result
import com.junmeng.handsome.entity.OperateLog
import com.junmeng.handsome.repository.OperateLogRepo
import com.junmeng.handsome.utils.ResultUtil
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

    @GetMapping(value="/")
    open fun index(model: ModelMap): ModelAndView {

         return ModelAndView("/index")
    }
    @GetMapping(value = "/index")
    open fun index1(): Result<List<OperateLog>> {
        var list: List<OperateLog>? = operateLogRepo?.findAll()
        // System.out.print("size=" + list?.get(0)?.operateType)
        return ResultUtil.success(list)
        // return ModelAndView("/index")
    }

}