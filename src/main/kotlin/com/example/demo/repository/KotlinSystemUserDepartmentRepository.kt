package com.example.demo.repository

import com.example.demo.entity.KotlinSystemUserDepartment
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation
import org.springframework.stereotype.Repository

@Repository
interface KotlinSystemUserDepartmentRepository : JpaRepositoryImplementation<KotlinSystemUserDepartment, Long> {
    @Modifying
    fun deleteByUserId(userId: Long)

    @Modifying
    fun deleteByUserIdIn(userId: Collection<Long>)

    @Modifying
    fun deleteByDepartId(departId: Long)

    @Modifying
    fun deleteByDepartIdIn(departId: MutableCollection<Long>)
}