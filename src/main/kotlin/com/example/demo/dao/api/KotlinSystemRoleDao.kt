package com.example.demo.dao.api

import com.example.demo.entity.KotlinSystemRole
import com.example.demo.entity.dto.KotlinSystemRoleWrapper
import com.example.demo.entity.dto.Pagination

interface KotlinSystemRoleDao {
    fun getType(): String
    fun saveData(kotlinTable: KotlinSystemRole)
    fun updateData(kotlinTable: KotlinSystemRole)
    fun get(id: Long): KotlinSystemRole
    fun getList(wrapper: KotlinSystemRoleWrapper): List<KotlinSystemRole>
    fun getPage(wrapper: KotlinSystemRoleWrapper, page: Int, size: Int): Pagination<KotlinSystemRole>
    fun deleteData(id: Array<Long>)

}