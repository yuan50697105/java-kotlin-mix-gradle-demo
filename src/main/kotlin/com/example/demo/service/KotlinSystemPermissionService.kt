package com.example.demo.service

import com.example.demo.entity.KotlinSystemPermission
import com.example.demo.entity.dto.KotlinSystemPermissionAddDTO
import com.example.demo.entity.dto.KotlinSystemPermissionUpdateDTO
import com.example.demo.entity.dto.KotlinSystemPermissionWrapper
import com.example.demo.entity.dto.Pagination

interface KotlinSystemPermissionService {
    fun saveData(kotlinTable: KotlinSystemPermissionAddDTO, type: String)
    fun updateData(table: KotlinSystemPermissionUpdateDTO, type: String)
    fun get(id: Long, type: String): KotlinSystemPermission?
    fun getList(wrapper: KotlinSystemPermissionWrapper, type: String): List<KotlinSystemPermission>?
    fun getPage(
        wrapper: KotlinSystemPermissionWrapper,
        page: Int,
        size: Int,
        type: String
    ): Pagination<KotlinSystemPermission>?

    fun deleteData(id: Array<Long>, type: String)

}
