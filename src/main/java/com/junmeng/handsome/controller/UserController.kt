package com.junmeng.handsome.controller

import com.junmeng.handsome.common.ConstantValue
import com.junmeng.handsome.domain.ApiResult
import com.junmeng.handsome.domain.LoginResult
import com.junmeng.handsome.entity.User
import com.junmeng.handsome.service.UserService
import com.junmeng.handsome.utils.ApiResultUtil
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.web.bind.annotation.*
import javax.servlet.http.HttpSession

/**
 * 用户接口
 * Created by hwj on 2017/5/22.
 */
@RestController
@RequestMapping(value = "api/user")
open class UserController {


    @Autowired
    lateinit var userService: UserService

    /**
     * 登录
     */
    @PostMapping(value = "/login")
    fun login(
            session: HttpSession,
            @RequestParam(value = "account", required = true) account: String, //账号，可为用户名，手机号，邮箱
            @RequestParam(value = "password", required = true) password: String//md5加密过的密码
    ): ApiResult<LoginResult> {
        var user: User = userService.login(account, password)
        // 设置session
        session.setAttribute(ConstantValue.LOGIN_SESSION, account)

        return ApiResultUtil.success(LoginResult(userId = user.userId!!))
    }

    /**
     * 登出
     */
    @GetMapping(value = "/logout")
    fun logout(
            session: HttpSession
    ): ApiResult<LoginResult> {
        // 移除session
        session.removeAttribute(ConstantValue.LOGIN_SESSION)
        return ApiResultUtil.success()
    }

    @PostMapping(value="/add")
    fun addOne(
            user:User
    ): ApiResult<String>{
        userService.addOrUpdateUser(user)
        return ApiResultUtil.success()
    }


    /**
     * 分页获取用户列表
     */
    @GetMapping(value = "/getUserList")
    fun getUserList(
            @RequestParam(value = "page", required = true) page: Int, //账号，可为用户名，手机号，邮箱
            @RequestParam(value = "size", required = true) size: Int//md5加密过的密码
    ): ApiResult<Page<User>> {

        return ApiResultUtil.success(userService.getUserList(page,size))
    }
}