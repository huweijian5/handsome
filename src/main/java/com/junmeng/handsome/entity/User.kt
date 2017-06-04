package com.junmeng.handsome.entity

import org.hibernate.annotations.Generated
import org.hibernate.annotations.GenerationTime
import org.springframework.format.annotation.DateTimeFormat
import java.io.Serializable
import java.util.*
import javax.persistence.*

/**
 * 用户表
 * Created by hwj on 2017/5/21.
 */
@Entity
@Table(name = "tb_user")
data class User(
        @Column(name = "user_id") @Id @GeneratedValue(strategy = GenerationType.IDENTITY) var userId: Long? = null,
        @Column(name = "user_name", nullable = false) var userName: String = "",
        @Column(name = "nick_name", nullable = false) var nickName: String = "junmeng",
        @Column(name = "mobile_phone", nullable = true) var mobilePhone: String? = null,
        @Column(name = "email", nullable = true) var email: String? = null,
        @Column(name = "password", nullable = false) var password: String = "123",
        @Column(name = "is_admin", nullable = false) var admin: Int = 0,//thymeleaf不允许出现is
        @Column(name = "status", nullable = false) var status: Int = 1,
        @Column(name = "create_time", nullable = false) @Generated(GenerationTime.INSERT) var createTime: Date = Date(),
        @Column(name = "update_time", nullable = false) @Generated(GenerationTime.ALWAYS) var updateTime: Date = Date()

) : Serializable {

    //空构造函数需要为每个参数提供默认值
    // protected constructor() : this(userId=null,userName = "",nickName = "junmeng",mobilePhone = null,email=null,
    //       password = "123",isAdmin = 0,status = 1,createTime = Date(),updateTime = Date()) {
    // }
}