package com.junmeng.handsome.entity

import java.io.Serializable
import javax.persistence.*

/**
 * Created by hwj on 2017/5/21.
 */
@Entity
@Table(name = "tb_user")
data class User(
        @Column(name = "user_id") @Id @GeneratedValue(strategy = GenerationType.AUTO) var userId: Int? = 0,
        @Column(name = "user_name", nullable = false) var userName: String? = null,
        @Column(name = "nick_name", nullable = true) var nickName: String? = "junmeng",
        @Column(name = "mobile_phone",nullable = true) var mobilePhone: String? = null

) : Serializable {

    //空构造函数需要为每个参数提供默认值
    protected constructor() : this(userId=0,userName = null,nickName = null,mobilePhone = null) {
    }
}