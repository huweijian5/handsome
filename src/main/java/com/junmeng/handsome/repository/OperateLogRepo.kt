package com.junmeng.handsome.repository

import com.junmeng.handsome.entity.OperateLog
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import javax.transaction.Transactional

/**
 * Created by hwj on 2017/5/21.
 */
@Repository
@Transactional
interface OperateLogRepo : JpaRepository<OperateLog,Long> {
}