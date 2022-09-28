package com.example.demo.dao.factory

import com.example.demo.entity.KotlinGoodsStock
import com.example.demo.entity.dto.KotlinGoodsStockWrapper
import com.example.demo.entity.dto.Pagination

interface KotlinGoodsStockDaoFactory {
    fun saveData(type: String, data: KotlinGoodsStock)
    fun updateData(type: String, data: KotlinGoodsStock)
    operator fun get(type: String, id: Long): KotlinGoodsStock?
    fun deleteData(type: String, ids: Array<Long>)
    fun deleteData(type: String, ids: Collection<Long>)
    fun deleteData(type: String, id: Long, vararg ids: Long)
    fun getList(type: String, wrapper: KotlinGoodsStockWrapper): List<KotlinGoodsStock>?
    fun getList(
        type: String,
        wrapper: KotlinGoodsStockWrapper,
        page: Int,
        size: Int,
    ): List<KotlinGoodsStock>?

    fun getPage(
        type: String,
        wrapper: KotlinGoodsStockWrapper,
        page: Int,
        size: Int,
    ): Pagination<KotlinGoodsStock>?
}