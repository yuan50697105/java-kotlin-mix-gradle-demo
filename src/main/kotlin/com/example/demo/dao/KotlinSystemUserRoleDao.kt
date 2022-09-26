package com.example.demo.dao

import com.example.demo.entity.KotlinSystemUserRole

interface KotlinSystemUserRoleDao {
    fun getType(): String
    fun saveData(kotlinTable: KotlinSystemUserRole)
    fun saveData(kotlinTable: List<KotlinSystemUserRole>)
    fun updateData(kotlinTable: KotlinSystemUserRole)
    fun get(id: Long): KotlinSystemUserRole
    fun deleteData(id: Array<Long>)
    fun updateData(userId: Long, roleIds: List<Long>)
    fun deleteDataByUserIds(userIds: Array<Long>)
    fun deleteDataByRoleIds(roleIds: Array<Long>)

}
