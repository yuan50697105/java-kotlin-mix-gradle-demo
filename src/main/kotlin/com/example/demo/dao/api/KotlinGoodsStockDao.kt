package com.example.demo.dao.api

import com.example.demo.entity.KotlinGoodsStock
import com.example.demo.entity.dto.KotlinGoodsStockWrapper
import com.example.demo.entity.dto.Pagination

interface KotlinGoodsStockDao {
    fun getType(): String
    fun saveData(javaSystemRole: KotlinGoodsStock)
    fun updateData(javaSystemRole: KotlinGoodsStock)
    operator fun get(id: Long): KotlinGoodsStock?
    fun deleteData(ids: Array<Long>)
    fun deleteData(ids: Collection<Long>)
    fun deleteData(id: Long, vararg ids: Long)
    fun getList(wrapper: KotlinGoodsStockWrapper): List<KotlinGoodsStock>?
    fun getList(wrapper: KotlinGoodsStockWrapper, page: Int, size: Int): List<KotlinGoodsStock>?
    fun getPage(wrapper: KotlinGoodsStockWrapper, page: Int, size: Int): Pagination<KotlinGoodsStock>?
}