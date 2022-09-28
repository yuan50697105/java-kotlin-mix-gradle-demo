package com.example.demo.repository

import com.example.demo.entity.KotlinGoodsInfo
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation
import org.springframework.stereotype.Repository

@Repository
interface KotlinGoodsInfoRepository : JpaRepositoryImplementation<KotlinGoodsInfo, Long>