package com.example.demo.repository

import com.example.demo.entity.KotlinCustomerInfo
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation
import org.springframework.stereotype.Repository

@Repository
interface KotlinCustomerInfoRepository : JpaRepositoryImplementation<KotlinCustomerInfo, Long>