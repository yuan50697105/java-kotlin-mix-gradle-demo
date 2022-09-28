package com.example.demo.service

import com.example.demo.entity.KotlinGoodsInfo
import com.example.demo.entity.dto.KotlinGoodsInfoAddDTO
import com.example.demo.entity.dto.KotlinGoodsInfoUpdateDTO
import com.example.demo.entity.dto.KotlinGoodsInfoWrapper
import com.example.demo.entity.dto.Pagination

interface KotlinGoodsInfoService {
    fun saveData(type: String, table: KotlinGoodsInfoAddDTO)
    fun updateData(type: String, table: KotlinGoodsInfoUpdateDTO)
    fun deleteData(type: String, id: Array<Long>)
    operator fun get(type: String, id: Long): KotlinGoodsInfo?
    fun getList(type: String, wrapper: KotlinGoodsInfoWrapper): List<KotlinGoodsInfo>?
    fun getPage(
        type: String,
        wrapper: KotlinGoodsInfoWrapper,
        page: Int,
        size: Int
    ): Pagination<KotlinGoodsInfo>?
}