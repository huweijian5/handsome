package com.junmeng.handsome.service

import com.junmeng.handsome.common.BussinessException
import com.junmeng.handsome.common.ResultCode
import com.junmeng.handsome.entity.User
import com.junmeng.handsome.repository.UserRepo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

/**
 * Created by hwj on 2017/5/25.
 */
@Service
@Transactional
open class UserService {

    @Autowired
    var userRepo: UserRepo? = null

    /**
     * 登录
     */
    open fun login(account: String, password: String): User {
        var user: User? = userRepo?.findUser(account)
        if (user == null) {
            throw BussinessException(ResultCode.FAILED, "账号不存在")
        }
        if (user.status != 1) {
            throw BussinessException(ResultCode.FAILED, "账号不可用")
        }
        if (!user?.password.equals(password, true)) {
            throw BussinessException(ResultCode.FAILED, "密码错误")
        }

        return user

    }


}