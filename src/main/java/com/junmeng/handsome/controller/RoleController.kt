package com.junmeng.handsome.controller

import com.junmeng.handsome.domain.ApiResult
import com.junmeng.handsome.entity.Access
import com.junmeng.handsome.entity.Role
import com.junmeng.handsome.service.AccessService
import com.junmeng.handsome.service.RoleService
import com.junmeng.handsome.utils.ApiResultUtil
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * Created by hwj on 2017/5/22.
 */
@RestController
@RequestMapping(value = "api/role")
open class RoleController {

    @Autowired
    lateinit var roleService: RoleService


    @PostMapping(value="/add")
    fun addOne(
            access: Role
    ): ApiResult<String> {
        roleService.addOrUpdateRole(access)
        return ApiResultUtil.success()
    }
}