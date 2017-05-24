package com.junmeng.handsome.repository

import com.junmeng.handsome.entity.RoleAccess
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

/**
 * Created by hwj on 2017/5/22.
 */
@Repository
interface RoleAccessRepo:JpaRepository<RoleAccess,Long> {
}