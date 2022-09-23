package com.example.demo.service

import com.example.demo.entity.KotlinTable
import com.example.demo.entity.dto.KotlinTableAddDTO
import com.example.demo.entity.dto.KotlinTableUpdateDTO
import com.example.demo.entity.dto.KotlinTableWrapper
import com.example.demo.entity.dto.Pagination

interface KotlinTableService {
    fun saveData(kotlinTable: KotlinTableAddDTO, type: String)
    fun updateData(table: KotlinTableUpdateDTO, type: String)
    fun get(id: Long, type: String): KotlinTable?
    fun getList(wrapper: KotlinTableWrapper, type: String): List<KotlinTable>?
    fun getPage(wrapper: KotlinTableWrapper, page: Int, size: Int, type: String): Pagination<KotlinTable>?
    fun deleteData(id: Array<Long>, type: String)

}
