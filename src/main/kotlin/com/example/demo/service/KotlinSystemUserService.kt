package com.example.demo.service

import com.example.demo.entity.KotlinSystemUser
import com.example.demo.entity.dto.KotlinSystemUserAddDTO
import com.example.demo.entity.dto.KotlinSystemUserUpdateDTO
import com.example.demo.entity.dto.KotlinSystemUserWrapper
import com.example.demo.entity.dto.Pagination

interface KotlinSystemUserService {
    fun saveData(kotlinTable: KotlinSystemUserAddDTO, type: String)
    fun updateData(table: KotlinSystemUserUpdateDTO, type: String)
    fun get(id: Long, type: String): KotlinSystemUser?
    fun getList(wrapper: KotlinSystemUserWrapper, type: String): List<KotlinSystemUser>?
    fun getPage(wrapper: KotlinSystemUserWrapper, page: Int, size: Int, type: String): Pagination<KotlinSystemUser>?
    fun deleteData(id: Array<Long>, type: String)

}
