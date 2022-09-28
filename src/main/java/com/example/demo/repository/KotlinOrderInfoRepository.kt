package com.example.demo.repository

import com.example.demo.entity.KotlinOrderInfo
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation
import org.springframework.stereotype.Repository

@Repository
interface KotlinOrderInfoRepository : JpaRepositoryImplementation<KotlinOrderInfo, Long> {

}
