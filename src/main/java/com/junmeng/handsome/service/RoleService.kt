package com.junmeng.handsome.service

import com.junmeng.handsome.entity.Access
import com.junmeng.handsome.entity.Role
import com.junmeng.handsome.repository.AccessRepo
import com.junmeng.handsome.repository.RoleRepo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort
import org.springframework.stereotype.Service
import javax.transaction.Transactional

/**
 * Created by hwj on 2017/6/13.
 */
@Service
@Transactional
open class RoleService {
    @Autowired
    lateinit var roleRepo: RoleRepo
    /**
     * 分页获得权限列表
     */
    open fun getRoles(page:Int,site:Int): Page<Role> {
        var order: Sort.Order= Sort.Order.desc("updateTime")
        var sort: Sort = Sort.by(order)
        var page: Pageable = PageRequest.of(page,site,sort)
        return roleRepo.findAll<Sort>(page)
    }

    fun  addOrUpdateRole(role: Role) {
        roleRepo.save(role)
    }
}