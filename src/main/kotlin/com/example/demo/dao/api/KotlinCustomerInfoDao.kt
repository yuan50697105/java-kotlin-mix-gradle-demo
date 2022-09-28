package com.example.demo.dao.api

import com.example.demo.entity.KotlinCustomerInfo
import com.example.demo.entity.dto.KotlinCustomerInfoWrapper
import com.example.demo.entity.dto.Pagination

interface KotlinCustomerInfoDao {
    fun getType(): String
    fun saveData(javaSystemRole: KotlinCustomerInfo)
    fun updateData(javaSystemRole: KotlinCustomerInfo)
    operator fun get(id: Long): KotlinCustomerInfo?
    fun deleteData(ids: Array<Long>)
    fun deleteData(ids: Collection<Long>)
    fun deleteData(id: Long, vararg ids: Long)
    fun getList(wrapper: KotlinCustomerInfoWrapper): List<KotlinCustomerInfo>?
    fun getList(wrapper: KotlinCustomerInfoWrapper, page: Int, size: Int): List<KotlinCustomerInfo>?
    fun getPage(wrapper: KotlinCustomerInfoWrapper, page: Int, size: Int): Pagination<KotlinCustomerInfo>?
}