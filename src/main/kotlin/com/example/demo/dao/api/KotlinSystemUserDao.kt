package com.example.demo.dao.api

import com.example.demo.entity.KotlinSystemUser
import com.example.demo.entity.dto.KotlinSystemUserWrapper
import com.example.demo.entity.dto.Pagination

interface KotlinSystemUserDao {
    fun getType(): String
    fun saveData(kotlinTable: KotlinSystemUser)
    fun updateData(kotlinTable: KotlinSystemUser)
    fun get(id: Long): KotlinSystemUser
    fun getList(wrapper: KotlinSystemUserWrapper): List<KotlinSystemUser>
    fun getPage(wrapper: KotlinSystemUserWrapper, page: Int, size: Int): Pagination<KotlinSystemUser>
    fun deleteData(id: Array<Long>)

}