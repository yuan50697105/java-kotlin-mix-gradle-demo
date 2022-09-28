package com.example.demo.service

import com.example.demo.entity.KotlinGoodsStock
import com.example.demo.entity.dto.KotlinGoodsStockAddDTO
import com.example.demo.entity.dto.KotlinGoodsStockUpdateDTO
import com.example.demo.entity.dto.KotlinGoodsStockWrapper
import com.example.demo.entity.dto.Pagination

interface KotlinGoodsStockService {
    fun saveData(type: String, table: KotlinGoodsStockAddDTO)
    fun updateData(type: String, table: KotlinGoodsStockUpdateDTO)
    fun deleteData(type: String, id: Array<Long>)
    operator fun get(type: String, id: Long): KotlinGoodsStock?
    fun getList(type: String, wrapper: KotlinGoodsStockWrapper): List<KotlinGoodsStock>?
    fun getPage(
        type: String,
        wrapper: KotlinGoodsStockWrapper,
        page: Int,
        size: Int,
    ): Pagination<KotlinGoodsStock>?
}