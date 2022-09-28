package com.example.demo.repository

import com.example.demo.entity.KotlinOrderDetail
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation
import org.springframework.stereotype.Repository

@Repository
interface KotlinOrderDetailRepository : JpaRepositoryImplementation<KotlinOrderDetail, Long> {

}
