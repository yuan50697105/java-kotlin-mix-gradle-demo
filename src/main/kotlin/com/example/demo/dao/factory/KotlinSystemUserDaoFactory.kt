package com.example.demo.dao.factory

import com.example.demo.entity.KotlinSystemUser
import com.example.demo.entity.dto.KotlinSystemUserWrapper
import com.example.demo.entity.dto.Pagination

interface KotlinSystemUserDaoFactory {
    fun saveData(kotlinTable: KotlinSystemUser, type: String)
    fun updateData(convertForUpdate: KotlinSystemUser, type: String)
    fun get(id: Long, type: String): KotlinSystemUser?
    fun getList(wrapper: KotlinSystemUserWrapper, type: String): List<KotlinSystemUser>?
    fun getPage(wrapper: KotlinSystemUserWrapper, page: Int, size: Int, type: String): Pagination<KotlinSystemUser>?
    fun deleteData(id: Array<Long>, type: String)

}