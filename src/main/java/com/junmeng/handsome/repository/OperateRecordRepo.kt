package com.junmeng.handsome.repository

import com.junmeng.handsome.entity.OperateRecord
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

/**
 * Created by hwj on 2017/5/21.
 */
@Repository
interface OperateRecordRepo : JpaRepository<OperateRecord,Int> {
}