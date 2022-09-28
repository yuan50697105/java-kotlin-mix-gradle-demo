package com.example.demo.dao.api

import com.example.demo.entity.KotlinSystemUserDepartment

interface KotlinSystemUserDepartmentDao {
    fun getType(): String
    fun saveData(javaSystemRole: KotlinSystemUserDepartment)
    fun updateData(javaSystemRole: KotlinSystemUserDepartment)
    operator fun get(id: Long): KotlinSystemUserDepartment?
    fun deleteData(ids: Array<Long>)
    fun deleteData(ids: Collection<Long>)
    fun deleteData(id: Long, vararg ids: Long)
    fun saveData(userId: Long, departIds: List<Long>)
    fun updateData(userId: Long, departIds: List<Long>)
    fun deleteDataByUserIds(userIds: Array<Long>)
    fun deleteDataByDepartIds(departIds: Array<Long>)
}