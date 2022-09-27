package com.example.demo.service

import com.example.demo.entity.KotlinSystemDepartment
import com.example.demo.entity.dto.KotlinSystemDepartmentAddDTO
import com.example.demo.entity.dto.KotlinSystemDepartmentUpdateDTO
import com.example.demo.entity.dto.KotlinSystemDepartmentWrapper
import com.example.demo.entity.dto.Pagination

interface KotlinSystemDepartmentService {
    fun saveData(type: String, table: KotlinSystemDepartmentAddDTO)
    fun updateData(type: String, table: KotlinSystemDepartmentUpdateDTO)
    fun deleteData(type: String, id: Array<Long>)
    operator fun get(type: String, id: Long): KotlinSystemDepartment?
    fun getList(type: String, wrapper: KotlinSystemDepartmentWrapper): List<KotlinSystemDepartment>?
    fun getPage(
        type: String,
        wrapper: KotlinSystemDepartmentWrapper,
        page: Int,
        size: Int
    ): Pagination<KotlinSystemDepartment>?
}