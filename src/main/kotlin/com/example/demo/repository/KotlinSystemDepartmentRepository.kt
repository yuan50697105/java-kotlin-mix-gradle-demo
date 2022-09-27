package com.example.demo.repository

import com.example.demo.entity.KotlinSystemDepartment
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation
import org.springframework.stereotype.Repository

@Repository
interface KotlinSystemDepartmentRepository : JpaRepositoryImplementation<KotlinSystemDepartment, Long>