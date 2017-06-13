package com.junmeng.handsome.entity

import org.hibernate.annotations.Generated
import org.hibernate.annotations.GenerationTime
import org.springframework.format.annotation.DateTimeFormat
import java.io.Serializable
import java.util.*
import javax.persistence.*

/**
 * 权限表
 * Created by hwj on 2017/5/21.
 */
@Entity
@Table(name = "tb_access")
data class Access (
        @Column(name = "access_id",nullable = false) @Id @GeneratedValue(strategy = GenerationType.IDENTITY) var accessId: Long? = null,
        @Column(name = "access_name", nullable = false) var accessName: String = "",
        @Column(name = "urls", nullable = false) var urls: String = "",
        @Column(name = "status",nullable = false) var status:Int = 1,
        @Column(name = "create_time",nullable = false) @Generated(GenerationTime.INSERT) var createTime: Date = Date(),
        @Column(name = "update_time",nullable = false) @Generated(GenerationTime.ALWAYS)  var updateTime: Date = Date()

        ) : Serializable {

}