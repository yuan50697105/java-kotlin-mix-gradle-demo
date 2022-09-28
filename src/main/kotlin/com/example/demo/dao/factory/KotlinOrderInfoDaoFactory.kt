package com.example.demo.dao.factory

import com.example.demo.entity.KotlinOrderInfo
import com.example.demo.entity.dto.KotlinOrderInfoWrapper
import com.example.demo.entity.dto.Pagination

interface KotlinOrderInfoDaoFactory {
    fun saveData(type: String, data: KotlinOrderInfo)
    fun updateData(type: String, data: KotlinOrderInfo)
    operator fun get(type: String, id: Long): KotlinOrderInfo?
    fun deleteData(type: String, ids: Array<Long>)
    fun deleteData(type: String, ids: Collection<Long>)
    fun deleteData(type: String, id: Long, vararg ids: Long)
    fun getList(type: String, wrapper: KotlinOrderInfoWrapper): List<KotlinOrderInfo>?
    fun getList(
        type: String,
        wrapper: KotlinOrderInfoWrapper,
        page: Int,
        size: Int
    ): List<KotlinOrderInfo>?

    fun getPage(
        type: String,
        wrapper: KotlinOrderInfoWrapper,
        page: Int,
        size: Int
    ): Pagination<KotlinOrderInfo>?
}