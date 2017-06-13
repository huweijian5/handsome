package com.junmeng.handsome.entity

import org.hibernate.annotations.Generated
import org.hibernate.annotations.GenerationTime
import java.io.Serializable
import java.util.*
import javax.persistence.*

/**
 * 角色表
 * Created by hwj on 2017/5/21.
 */
@Entity
@Table(name = "tb_role")
data class Role(
        @Column(name = "role_id") @Id @GeneratedValue(strategy = GenerationType.IDENTITY) var roleId: Long? = null,
        @Column(name = "role_name", nullable = false) var roleName: String = "",
        @Column(name = "status", nullable = false) var status: Int = 1,
        @Column(name = "create_time", nullable = false) @Generated(GenerationTime.INSERT) var createTime: Date = Date(),
        @Column(name = "update_time", nullable = false) @Generated(GenerationTime.ALWAYS) var updateTime: Date = Date()

) : Serializable {

}