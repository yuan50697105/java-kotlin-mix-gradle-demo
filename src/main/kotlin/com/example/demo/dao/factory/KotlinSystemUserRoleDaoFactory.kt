package com.example.demo.dao.factory

import com.example.demo.entity.KotlinSystemUserRole

interface KotlinSystemUserRoleDaoFactory {
    fun saveData(kotlinTable: KotlinSystemUserRole, type: String)
    fun updateData(convertForUpdate: KotlinSystemUserRole, type: String)
    fun get(id: Long, type: String): KotlinSystemUserRole?
    fun deleteData(id: Array<Long>, type: String)
    fun saveData(type: String, userId: Long?, roleIds: List<Long>?)
    fun updateData(type: String, userId: Long?, roleIds: List<Long>?)
    fun deleteDataByUserIds(type: String, userIds: Array<Long>)
    fun deleteDataByRoleIds(type: String, roleIds: Array<Long>)

}