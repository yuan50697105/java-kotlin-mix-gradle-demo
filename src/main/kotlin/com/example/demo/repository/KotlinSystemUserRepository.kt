package com.example.demo.repository

import com.example.demo.entity.KotlinSystemUser
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation
import org.springframework.stereotype.Repository

@Repository
interface KotlinSystemUserRepository : JpaRepositoryImplementation<KotlinSystemUser, Long> {
}