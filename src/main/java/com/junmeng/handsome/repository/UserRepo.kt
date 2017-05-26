package com.junmeng.handsome.repository

import com.junmeng.handsome.entity.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository
import javax.transaction.Transactional

/**
 * Created by hwj on 2017/5/22.
 */
@Repository
@Transactional
open interface UserRepo : JpaRepository<User, Long> {

    @Query(value = "select user from User user where user.userName=:account or user.mobilePhone=:account or user.email=:account")
    fun findUser(@Param("account") account: String): User
}