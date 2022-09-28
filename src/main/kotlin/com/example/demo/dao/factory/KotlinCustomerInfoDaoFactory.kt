package com.example.demo.dao.factory

import com.example.demo.entity.KotlinCustomerInfo
import com.example.demo.entity.dto.KotlinCustomerInfoWrapper
import com.example.demo.entity.dto.Pagination

interface KotlinCustomerInfoDaoFactory {
    fun saveData(type: String, data: KotlinCustomerInfo)
    fun updateData(type: String, data: KotlinCustomerInfo)
    operator fun get(type: String, id: Long): KotlinCustomerInfo?
    fun deleteData(type: String, ids: Array<Long>)
    fun deleteData(type: String, ids: Collection<Long>)
    fun deleteData(type: String, id: Long, vararg ids: Long)
    fun getList(type: String, wrapper: KotlinCustomerInfoWrapper): List<KotlinCustomerInfo>?
    fun getList(
        type: String,
        wrapper: KotlinCustomerInfoWrapper,
        page: Int,
        size: Int
    ): List<KotlinCustomerInfo>?

    fun getPage(
        type: String,
        wrapper: KotlinCustomerInfoWrapper,
        page: Int,
        size: Int
    ): Pagination<KotlinCustomerInfo>?
}