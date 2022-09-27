package com.example.demo.repository

import com.example.demo.entity.KotlinSystemRolePermission
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation
import org.springframework.stereotype.Repository

@Repository
interface KotlinSystemRolePermissionRepository : JpaRepositoryImplementation<KotlinSystemRolePermission, Long> {
}