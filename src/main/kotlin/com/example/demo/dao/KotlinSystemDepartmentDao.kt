package com.example.demo.dao

import com.example.demo.entity.KotlinSystemDepartment
import com.example.demo.entity.dto.KotlinSystemDepartmentWrapper
import com.example.demo.entity.dto.Pagination

interface KotlinSystemDepartmentDao {
    fun getType(): String
    fun saveData(javaSystemRole: KotlinSystemDepartment)
    fun updateData(javaSystemRole: KotlinSystemDepartment)
    operator fun get(id: Long): KotlinSystemDepartment?
    fun deleteData(ids: Array<Long>)
    fun deleteData(ids: Collection<Long>)
    fun deleteData(id: Long, vararg ids: Long)
    fun getList(wrapper: KotlinSystemDepartmentWrapper): List<KotlinSystemDepartment>?
    fun getList(wrapper: KotlinSystemDepartmentWrapper, page: Int, size: Int): List<KotlinSystemDepartment>?
    fun getPage(wrapper: KotlinSystemDepartmentWrapper, page: Int, size: Int): Pagination<KotlinSystemDepartment>?
}