package com.example.demo.dao.factory

import com.example.demo.entity.KotlinGoodsInfo
import com.example.demo.entity.dto.KotlinGoodsInfoWrapper
import com.example.demo.entity.dto.Pagination

interface KotlinGoodsInfoDaoFactory {
    fun saveData(type: String, data: KotlinGoodsInfo)
    fun updateData(type: String, data: KotlinGoodsInfo)
    operator fun get(type: String, id: Long): KotlinGoodsInfo?
    fun deleteData(type: String, ids: Array<Long>)
    fun deleteData(type: String, ids: Collection<Long>)
    fun deleteData(type: String, id: Long, vararg ids: Long)
    fun getList(type: String, wrapper: KotlinGoodsInfoWrapper): List<KotlinGoodsInfo>?
    fun getList(
        type: String,
        wrapper: KotlinGoodsInfoWrapper,
        page: Int,
        size: Int
    ): List<KotlinGoodsInfo>?

    fun getPage(
        type: String,
        wrapper: KotlinGoodsInfoWrapper,
        page: Int,
        size: Int
    ): Pagination<KotlinGoodsInfo>?
}