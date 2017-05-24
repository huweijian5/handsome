package com.junmeng.handsome.entity

import java.io.Serializable
import java.util.*
import javax.persistence.*

/**
 * 用户角色关联表
 * Created by hwj on 2017/5/21.
 */
@Entity
@Table(name = "tb_user_role")
data class UserRole(
        @Column(name = "id") @Id @GeneratedValue(strategy = GenerationType.IDENTITY) var id: Long? = null,
        @Column(name = "user_id", nullable = false) var userId: Long = 0,
        @Column(name = "role_id", nullable = false) var roleId: Long = 0,
        @Column(name = "create_time", nullable = false) @Transient var createTime: Date = Date(),
        @Column(name = "update_time", nullable = false) @Transient var updateTime: Date = Date()

) : Serializable {

}