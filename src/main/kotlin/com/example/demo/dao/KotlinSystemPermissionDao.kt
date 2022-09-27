package com.example.demo.dao

import com.example.demo.entity.KotlinSystemPermission
import com.example.demo.entity.dto.KotlinSystemPermissionWrapper
import com.example.demo.entity.dto.Pagination

interface KotlinSystemPermissionDao {
    fun getType(): String
    fun saveData(kotlinTable: KotlinSystemPermission)
    fun updateData(kotlinTable: KotlinSystemPermission)
    fun get(id: Long): KotlinSystemPermission
    fun getList(wrapper: KotlinSystemPermissionWrapper): List<KotlinSystemPermission>
    fun getPage(wrapper: KotlinSystemPermissionWrapper, page: Int, size: Int): Pagination<KotlinSystemPermission>
    fun deleteData(id: Array<Long>)

}
