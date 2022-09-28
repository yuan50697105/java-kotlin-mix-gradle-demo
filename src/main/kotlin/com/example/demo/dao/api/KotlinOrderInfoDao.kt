package com.example.demo.dao.api

import com.example.demo.entity.KotlinOrderInfo
import com.example.demo.entity.dto.KotlinOrderInfoWrapper
import com.example.demo.entity.dto.Pagination

interface KotlinOrderInfoDao {
    fun getType(): String
    fun saveData(javaSystemRole: KotlinOrderInfo)
    fun updateData(javaSystemRole: KotlinOrderInfo)
    operator fun get(id: Long): KotlinOrderInfo?
    fun deleteData(ids: Array<Long>)
    fun deleteData(ids: Collection<Long>)
    fun deleteData(id: Long, vararg ids: Long)
    fun getList(wrapper: KotlinOrderInfoWrapper): List<KotlinOrderInfo>?
    fun getList(wrapper: KotlinOrderInfoWrapper, page: Int, size: Int): List<KotlinOrderInfo>?
    fun getPage(wrapper: KotlinOrderInfoWrapper, page: Int, size: Int): Pagination<KotlinOrderInfo>?
}