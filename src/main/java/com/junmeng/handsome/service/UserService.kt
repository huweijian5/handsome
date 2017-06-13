package com.junmeng.handsome.service

import com.junmeng.handsome.common.BussinessException
import com.junmeng.handsome.common.ResultCode
import com.junmeng.handsome.entity.User
import com.junmeng.handsome.repository.UserRepo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort
import org.springframework.expression.spel.ast.Elvis
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

/**
 * Created by hwj on 2017/5/25.
 */
@Service
@Transactional
open class UserService {

    @Autowired
   lateinit var userRepo: UserRepo

    /**
     * 登录
     */
    open fun login(account: String, password: String): User {
        var user: User = userRepo.findUser(account) ?: throw BussinessException(ResultCode.FAILED, "账号不存在")
        if (user.status != 1) {
            throw BussinessException(ResultCode.FAILED, "账号不可用")
        }
        if (!user.password.equals(password, true)) {
            throw BussinessException(ResultCode.FAILED, "密码错误")
        }

        return user

    }

    /**
     * 分页获得用户列表
     */
    open fun getUserList(page:Int,site:Int): Page<User> {
        var order:Sort.Order= Sort.Order.by("userId")
        var sort:Sort=Sort.by(order)
        var page:Pageable= PageRequest.of(page,site,sort)
        return userRepo.findAll<Sort>(page)
    }

    /**
     * 添加新用户
     */
    open fun addUsers(users:List<User>):List<User>{
        return userRepo.saveAll(users)
    }

    /**
     * 添加或更新用户
     */
    open fun addOrUpdateUser(user:User):User?{
        return userRepo?.save(user)
    }

    /**
     * 删除用户
     */
    open fun deleteUsers(users:List<User>){
        userRepo.deleteAll(users)
    }

    /**
     * 删除指定userId的用户
     */
    open fun deleteUserById(useId:Long){
        userRepo.deleteById(useId)
    }








}