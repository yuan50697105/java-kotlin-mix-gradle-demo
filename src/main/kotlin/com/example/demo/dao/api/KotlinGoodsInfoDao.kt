package com.example.demo.dao.api

import com.example.demo.entity.KotlinGoodsInfo
import com.example.demo.entity.dto.KotlinGoodsInfoWrapper
import com.example.demo.entity.dto.Pagination

interface KotlinGoodsInfoDao {
    fun getType(): String
    fun saveData(javaSystemRole: KotlinGoodsInfo)
    fun updateData(javaSystemRole: KotlinGoodsInfo)
    operator fun get(id: Long): KotlinGoodsInfo?
    fun deleteData(ids: Array<Long>)
    fun deleteData(ids: Collection<Long>)
    fun deleteData(id: Long, vararg ids: Long)
    fun getList(wrapper: KotlinGoodsInfoWrapper): List<KotlinGoodsInfo>?
    fun getList(wrapper: KotlinGoodsInfoWrapper, page: Int, size: Int): List<KotlinGoodsInfo>?
    fun getPage(wrapper: KotlinGoodsInfoWrapper, page: Int, size: Int): Pagination<KotlinGoodsInfo>?
}