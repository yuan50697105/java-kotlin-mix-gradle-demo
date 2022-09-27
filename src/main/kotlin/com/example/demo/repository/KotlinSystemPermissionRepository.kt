package com.example.demo.repository

import com.example.demo.entity.KotlinSystemPermission
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation
import org.springframework.stereotype.Repository

@Repository
interface KotlinSystemPermissionRepository : JpaRepositoryImplementation<KotlinSystemPermission, Long> {
}