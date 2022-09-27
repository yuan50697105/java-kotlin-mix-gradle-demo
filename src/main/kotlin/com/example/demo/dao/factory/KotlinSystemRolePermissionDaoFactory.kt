package com.example.demo.dao.factory

import com.example.demo.entity.KotlinSystemRolePermission

interface KotlinSystemRolePermissionDaoFactory {
    fun saveData(type: String, kotlinTable: KotlinSystemRolePermission)
    fun updateData(type: String, kotlinSystemRolePermission: KotlinSystemRolePermission)
    fun get(type: String, id: Long): KotlinSystemRolePermission?
    fun deleteData(type: String, id: Array<Long>)
    fun saveData(type: String, roleId: Long?, permissionIds: List<Long>?)
    fun updateData(type: String, roleId: Long?, permissionIds: List<Long>?)
    fun deleteDataByRoleIds(type: String, roleIds: Array<Long>)
    fun saveData(type: String, kotlinTable: List<KotlinSystemRolePermission>)

}