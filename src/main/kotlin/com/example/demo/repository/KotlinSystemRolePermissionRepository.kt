package com.example.demo.repository

import com.example.demo.entity.KotlinSystemRolePermission
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation
import org.springframework.stereotype.Repository

@Repository
interface KotlinSystemRolePermissionRepository : JpaRepositoryImplementation<KotlinSystemRolePermission, Long> {
    fun deleteByRoleIdIn(roleId: Collection<Long>)

    fun deleteByRoleId(roleId: Long)

    fun deleteByPermissionId(permissionId: Long)

    fun deleteByPermissionIdIn(permissionId: Collection<Long>)


}