package com.example.demo.dao.factory

import com.example.demo.entity.KotlinOrderDetail
import com.example.demo.entity.dto.KotlinOrderDetailWrapper
import com.example.demo.entity.dto.Pagination

interface KotlinOrderDetailDaoFactory {
    fun saveData(type: String, data: KotlinOrderDetail)
    fun updateData(type: String, data: KotlinOrderDetail)
    operator fun get(type: String, id: Long): KotlinOrderDetail?
    fun deleteData(type: String, ids: Array<Long>)
    fun deleteData(type: String, ids: Collection<Long>)
    fun deleteData(type: String, id: Long, vararg ids: Long)
    fun getList(type: String, wrapper: KotlinOrderDetailWrapper): List<KotlinOrderDetail>?
    fun getList(
        type: String,
        wrapper: KotlinOrderDetailWrapper,
        page: Int,
        size: Int
    ): List<KotlinOrderDetail>?

    fun getPage(
        type: String,
        wrapper: KotlinOrderDetailWrapper,
        page: Int,
        size: Int
    ): Pagination<KotlinOrderDetail>?
}