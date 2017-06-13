package com.junmeng.handsome.controller

import com.junmeng.handsome.domain.ApiResult
import com.junmeng.handsome.entity.Access
import com.junmeng.handsome.service.AccessService
import com.junmeng.handsome.utils.ApiResultUtil
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * Created by hwj on 2017/5/22.
 */
@RestController
@RequestMapping(value = "api/access")
open class AccessController {

    @Autowired
    lateinit var accessService: AccessService


    @PostMapping(value="/add")
    fun addOne(
            access: Access
    ): ApiResult<String> {
        accessService.addOrUpdateUser(access)
        return ApiResultUtil.success()
    }
}