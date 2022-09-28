package com.example.demo.dao.api

import com.example.demo.entity.KotlinTable
import com.example.demo.entity.dto.KotlinTableWrapper
import com.example.demo.entity.dto.Pagination

interface KotlinTableDao {
    fun getType(): String
    fun saveData(kotlinTable: KotlinTable)
    fun updateData(kotlinTable: KotlinTable)
    fun get(id: Long): KotlinTable
    fun getList(wrapper: KotlinTableWrapper): List<KotlinTable>
    fun getPage(wrapper: KotlinTableWrapper, page: Int, size: Int): Pagination<KotlinTable>
    fun deleteData(id: Array<Long>)

}