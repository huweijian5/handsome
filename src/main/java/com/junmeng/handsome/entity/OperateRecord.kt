package com.junmeng.handsome.entity

import org.springframework.format.annotation.DateTimeFormat
import java.io.Serializable
import java.util.*
import javax.persistence.*

/**
 * Created by hwj on 2017/5/21.
 */
@Entity
@Table(name = "tb_operate_record")
data class OperateRecord(
        @Column(name="id") @Id @GeneratedValue(strategy=GenerationType.AUTO) var id:Int=0,
        @Column(name="user_id") var userId:Int=0,
        @Column(name="operate_type") var operateType:String="",
        @Column(name="create_time") @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") var createTime:Date?=null,
        @Column(name="update_time") @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")var updateTime:Date?=null

):Serializable{

}
