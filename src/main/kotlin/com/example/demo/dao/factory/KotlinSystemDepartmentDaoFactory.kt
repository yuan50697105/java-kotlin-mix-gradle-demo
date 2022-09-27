package com.example.demo.dao.factory

import com.example.demo.entity.KotlinSystemDepartment
import com.example.demo.entity.dto.KotlinSystemDepartmentWrapper
import com.example.demo.entity.dto.Pagination

interface KotlinSystemDepartmentDaoFactory {
    fun saveData(type: String, data: KotlinSystemDepartment)
    fun updateData(type: String, data: KotlinSystemDepartment)
    operator fun get(type: String, id: Long): KotlinSystemDepartment?
    fun deleteData(type: String, ids: Array<Long>)
    fun deleteData(type: String, ids: Collection<Long>)
    fun deleteData(type: String, id: Long, vararg ids: Long)
    fun getList(type: String, wrapper: KotlinSystemDepartmentWrapper): List<KotlinSystemDepartment>?
    fun getList(
        type: String,
        wrapper: KotlinSystemDepartmentWrapper,
        page: Int,
        size: Int
    ): List<KotlinSystemDepartment>?

    fun getPage(
        type: String,
        wrapper: KotlinSystemDepartmentWrapper,
        page: Int,
        size: Int
    ): Pagination<KotlinSystemDepartment>?
}