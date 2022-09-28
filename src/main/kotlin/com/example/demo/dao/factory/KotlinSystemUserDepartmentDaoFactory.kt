package com.example.demo.dao.factory

import com.example.demo.entity.KotlinSystemUserDepartment

interface KotlinSystemUserDepartmentDaoFactory {
    fun saveData(type: String, data: KotlinSystemUserDepartment)
    fun updateData(type: String, data: KotlinSystemUserDepartment)
    operator fun get(type: String, id: Long): KotlinSystemUserDepartment?
    fun deleteData(type: String, ids: Array<Long>)
    fun deleteData(type: String, ids: Collection<Long>)
    fun deleteData(type: String, id: Long, vararg ids: Long)
    fun saveData(type: String, userId: Long?, departIds: List<Long>?)
    fun updateData(type: String, userId: Long?, departIds: List<Long>?)
    fun deleteDataByUserIds(type: String, userIds: Array<Long>)
    fun deleteDataByDepartIds(type: String, id: Array<Long>)
}