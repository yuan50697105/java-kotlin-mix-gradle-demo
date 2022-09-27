package com.example.demo.dao

import com.example.demo.entity.KotlinSystemRolePermission

interface KotlinSystemRolePermissionDao {
    fun getType(): String
    fun saveData(kotlinTable: KotlinSystemRolePermission)
    fun updateData(kotlinTable: KotlinSystemRolePermission)
    fun get(id: Long): KotlinSystemRolePermission
    fun deleteData(id: Array<Long>)
    fun saveData(roleId: Long, permissionIds: List<Long>)

    fun saveData(kotlinTable: List<KotlinSystemRolePermission>)
    fun updateData(roleId: Long, permissionIds: List<Long>)
    fun deleteDataByRoleIds(roleIds: Array<Long>)
}
