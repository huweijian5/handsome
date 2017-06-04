package com.junmeng.handsome.service

import com.junmeng.handsome.entity.OperateLog
import com.junmeng.handsome.repository.OperateLogRepo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort
import org.springframework.stereotype.Service
import javax.transaction.Transactional

/**
 * Created by hwj on 2017/6/4.
 */
@Service
@Transactional
open class OperateLogService{
    @Autowired
    var operateLogRepo: OperateLogRepo? = null

    /**
     * 分页获得操作记录列表
     */
    open fun getLogs(page:Int,site:Int): Page<OperateLog> {
        var order: Sort.Order= Sort.Order.desc("updateTime")
        var sort: Sort = Sort.by(order)
        var page: Pageable = PageRequest.of(page,site,sort)
        return operateLogRepo?.findAll<Sort>(page)!!
    }

}