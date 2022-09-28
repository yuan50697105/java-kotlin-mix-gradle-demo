package com.example.demo.dao.api

import com.example.demo.entity.KotlinOrderDetail
import com.example.demo.entity.dto.KotlinOrderDetailWrapper
import com.example.demo.entity.dto.Pagination

interface KotlinOrderDetailDao {
    fun getType(): String
    fun saveData(javaSystemRole: KotlinOrderDetail)
    fun updateData(javaSystemRole: KotlinOrderDetail)
    operator fun get(id: Long): KotlinOrderDetail?
    fun deleteData(ids: Array<Long>)
    fun deleteData(ids: Collection<Long>)
    fun deleteData(id: Long, vararg ids: Long)
    fun getList(wrapper: KotlinOrderDetailWrapper): List<KotlinOrderDetail>?
    fun getList(wrapper: KotlinOrderDetailWrapper, page: Int, size: Int): List<KotlinOrderDetail>?
    fun getPage(wrapper: KotlinOrderDetailWrapper, page: Int, size: Int): Pagination<KotlinOrderDetail>?
}