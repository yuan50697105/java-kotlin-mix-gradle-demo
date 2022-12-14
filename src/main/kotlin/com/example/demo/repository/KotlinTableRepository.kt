package com.example.demo.repository

import com.example.demo.entity.KotlinTable
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation
import org.springframework.stereotype.Repository

@Repository
interface KotlinTableRepository : JpaRepositoryImplementation<KotlinTable, Long> {
}