package com.junmeng.handsome.controller

import com.junmeng.handsome.domain.Result
import com.junmeng.handsome.entity.OperateRecord
import com.junmeng.handsome.repository.OperateRecordRepo
import com.junmeng.handsome.utils.ResultUtil
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.servlet.ModelAndView

/**
 * Created by hwj on 2017/5/21.
 */
@RestController
class IndexController {

    @Autowired
    var operateRecordRepo: OperateRecordRepo? = null

    @GetMapping(value = "/index")
    fun index(): Result<List<OperateRecord>> {
        var list:List<OperateRecord>? =  operateRecordRepo?.findAll()
       // System.out.print("size=" + list?.get(0)?.operateType)
        return ResultUtil.success(list)
       // return ModelAndView("/index")
    }

}