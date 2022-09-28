package com.example.demo.service

import com.example.demo.entity.KotlinOrderInfo
import com.example.demo.entity.dto.KotlinOrderInfoAddDTO
import com.example.demo.entity.dto.KotlinOrderInfoUpdateDTO
import com.example.demo.entity.dto.KotlinOrderInfoWrapper
import com.example.demo.entity.dto.Pagination

interface KotlinOrderInfoService {
    fun saveData(type: String, table: KotlinOrderInfoAddDTO)
    fun updateData(type: String, table: KotlinOrderInfoUpdateDTO)
    fun deleteData(type: String, id: Array<Long>)
    operator fun get(type: String, id: Long): KotlinOrderInfo?
    fun getList(type: String, wrapper: KotlinOrderInfoWrapper): List<KotlinOrderInfo>?
    fun getPage(
        type: String,
        wrapper: KotlinOrderInfoWrapper,
        page: Int,
        size: Int
    ): Pagination<KotlinOrderInfo>?
}