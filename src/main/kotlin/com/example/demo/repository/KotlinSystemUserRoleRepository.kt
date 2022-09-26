package com.example.demo.repository

import com.example.demo.entity.KotlinSystemUserRole
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation
import org.springframework.stereotype.Repository

@Repository
interface KotlinSystemUserRoleRepository : JpaRepositoryImplementation<KotlinSystemUserRole, Long> {
    @Modifying
    fun deleteByUserIdIn(userId: Collection<Long>)

    @Modifying
    fun deleteByRoleIdIn(roleId: Collection<Long>)

    @Modifying
    fun deleteByUserId(userId: Long)

}