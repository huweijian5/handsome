package com.junmeng.handsome.entity

import org.hibernate.annotations.Generated
import org.hibernate.annotations.GenerationTime
import java.io.Serializable
import java.util.*
import javax.persistence.*

/**
 * 用户操作记录表
 * note:
 * @Transient 忽略某个字段
 * GenerationTime.INSERT 插入时自动更新时间
 * GenerationTime.ALWAYS 更新时自动更新时间
 * 经测试，下面两个注解并无卵用，需要在yml中设置才有效
 * @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
 * Created by hwj on 2017/5/21.
 */
@Entity
@Table(name = "tb_operate_log")
data class OperateLog(
        @Column(name = "id", nullable = false) @Id @GeneratedValue(strategy = GenerationType.IDENTITY) var id: Long? = null,
        @Column(name = "user_id", nullable = false) var userId: Long = 0,
        @Column(name = "target_url", nullable = false) var targetUrl: String = "",
        @Column(name = "query_param", nullable = false) var queryParam: String = "",
        @Column(name = "ip", nullable = false) var ip: String = "",
        @Column(name = "user_agent", nullable = false) var userAgent: String = "",
        @Column(name = "remark", nullable = false) var remark: String = "",
        @Column(name = "create_time", nullable = false) @Generated(GenerationTime.INSERT) var createTime: Date = Date(),
        @Column(name = "update_time", nullable = false) @Generated(GenerationTime.ALWAYS) var updateTime: Date = Date()
) : Serializable {
    protected constructor() : this(id = null, userId = 0, targetUrl = "", queryParam = "",
            ip = "", userAgent = "", remark = "", createTime = Date(), updateTime = Date()) {
    }
}
