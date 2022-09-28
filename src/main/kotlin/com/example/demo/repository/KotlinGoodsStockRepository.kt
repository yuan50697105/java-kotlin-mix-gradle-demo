package com.example.demo.repository

import com.example.demo.entity.KotlinGoodsStock
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation
import org.springframework.stereotype.Repository

@Repository
interface KotlinGoodsStockRepository : JpaRepositoryImplementation<KotlinGoodsStock, Long>