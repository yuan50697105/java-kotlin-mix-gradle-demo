package com.example.demo.service

import com.example.demo.entity.KotlinSystemRole
import com.example.demo.entity.dto.KotlinSystemRoleAddDTO
import com.example.demo.entity.dto.KotlinSystemRoleUpdateDTO
import com.example.demo.entity.dto.KotlinSystemRoleWrapper
import com.example.demo.entity.dto.Pagination

interface KotlinSystemRoleService {
    fun saveData(kotlinTable: KotlinSystemRoleAddDTO, type: String)
    fun updateData(table: KotlinSystemRoleUpdateDTO, type: String)
    fun get(id: Long, type: String): KotlinSystemRole?
    fun getList(wrapper: KotlinSystemRoleWrapper, type: String): List<KotlinSystemRole>?
    fun getPage(wrapper: KotlinSystemRoleWrapper, page: Int, size: Int, type: String): Pagination<KotlinSystemRole>?
    fun deleteData(id: Array<Long>, type: String)

}
