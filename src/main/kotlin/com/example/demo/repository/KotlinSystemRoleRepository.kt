package com.example.demo.repository

import com.example.demo.entity.KotlinSystemRole
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation
import org.springframework.stereotype.Repository

@Repository
interface KotlinSystemRoleRepository : JpaRepositoryImplementation<KotlinSystemRole, Long> {
}