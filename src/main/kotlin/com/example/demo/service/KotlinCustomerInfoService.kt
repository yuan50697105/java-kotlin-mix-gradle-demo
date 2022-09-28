package com.example.demo.service

import com.example.demo.entity.KotlinCustomerInfo
import com.example.demo.entity.dto.KotlinCustomerInfoAddDTO
import com.example.demo.entity.dto.KotlinCustomerInfoUpdateDTO
import com.example.demo.entity.dto.KotlinCustomerInfoWrapper
import com.example.demo.entity.dto.Pagination

interface KotlinCustomerInfoService {
    fun saveData(type: String, table: KotlinCustomerInfoAddDTO)
    fun updateData(type: String, table: KotlinCustomerInfoUpdateDTO)
    fun deleteData(type: String, id: Array<Long>)
    operator fun get(type: String, id: Long): KotlinCustomerInfo?
    fun getList(type: String, wrapper: KotlinCustomerInfoWrapper): List<KotlinCustomerInfo>?
    fun getPage(
        type: String,
        wrapper: KotlinCustomerInfoWrapper,
        page: Int,
        size: Int
    ): Pagination<KotlinCustomerInfo>?
}