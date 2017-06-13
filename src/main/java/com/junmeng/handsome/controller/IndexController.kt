package com.junmeng.handsome.controller

import com.junmeng.handsome.domain.ApiResult
import com.junmeng.handsome.entity.OperateLog
import com.junmeng.handsome.repository.OperateLogRepo
import com.junmeng.handsome.service.AccessService
import com.junmeng.handsome.service.OperateLogService
import com.junmeng.handsome.service.RoleService
import com.junmeng.handsome.service.UserService
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
    lateinit var operateLogRepo: OperateLogRepo

    @Autowired
    lateinit var userService: UserService

    @Autowired
    lateinit var operateLogService: OperateLogService

    @Autowired
    lateinit var accessService: AccessService

    @Autowired
    lateinit var roleService: RoleService

    @GetMapping(value= "/login")
    open fun login(model: ModelMap): ModelAndView {
         return ModelAndView("/login")
    }

    @GetMapping(value = "/log")
    open fun log(): ApiResult<List<OperateLog>> {
        var list: List<OperateLog> = operateLogRepo.findAll()
        return ApiResultUtil.success(list)
    }
    @GetMapping(value = "/index")
    open fun index(): ModelAndView {
        return ModelAndView("/index")
    }

    @GetMapping(value = "/user/list")
    open fun gotoUserList(model: ModelMap): ModelAndView {
        model.addAttribute("userList", userService.getUserList(0,10).content)

        return ModelAndView("/userMgr/list1")
    }

    @GetMapping(value = "/user/add")
    open fun gotoUserAdd(model: ModelMap): ModelAndView {
        return ModelAndView("/userMgr/add")
    }

    @GetMapping(value = "/log/list")
    open fun gotoLogList(model: ModelMap): ModelAndView {
        model.addAttribute("logs", operateLogService.getLogs(0,10).content)

        return ModelAndView("/logMgr/list")
    }

    @GetMapping(value = "/access/list")
    open fun gotoAccessList(model: ModelMap): ModelAndView {
        model.addAttribute("accessList", accessService.getAccess(0,10).content)
        return ModelAndView("/accessMgr/list")
    }

    @GetMapping(value = "/access/add")
    open fun gotoAccessAdd(model: ModelMap): ModelAndView {
        return ModelAndView("/accessMgr/add")
    }


    @GetMapping(value = "/role/list")
    open fun gotoRoleList(model: ModelMap): ModelAndView {
        model.addAttribute("roleList", roleService.getRoles(0,10).content)
        return ModelAndView("/roleMgr/list")
    }

    @GetMapping(value = "/role/add")
    open fun gotoRoleAdd(model: ModelMap): ModelAndView {
        return ModelAndView("/roleMgr/add")
    }
}