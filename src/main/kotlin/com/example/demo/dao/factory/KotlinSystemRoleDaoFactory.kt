package com.example.demo.dao.factory

import com.example.demo.entity.KotlinSystemRole
import com.example.demo.entity.dto.KotlinSystemRoleWrapper
import com.example.demo.entity.dto.Pagination

interface KotlinSystemRoleDaoFactory {
    fun saveData(kotlinTable: KotlinSystemRole, type: String)
    fun updateData(convertForUpdate: KotlinSystemRole, type: String)
    fun get(id: Long, type: String): KotlinSystemRole?
    fun getList(wrapper: KotlinSystemRoleWrapper, type: String): List<KotlinSystemRole>?
    fun getPage(wrapper: KotlinSystemRoleWrapper, page: Int, size: Int, type: String): Pagination<KotlinSystemRole>?
    fun deleteData(id: Array<Long>, type: String)

}