package com.example.demo.service

import com.example.demo.entity.KotlinTable
import com.example.demo.entity.dto.KotlinTableWrapper
import com.example.demo.entity.dto.Pagination

interface KotlinTableDaoFactory {
    fun saveData(kotlinTable: KotlinTable, type: String)
    fun updateData(convertForUpdate: KotlinTable, type: String)
    fun get(id: Long, type: String): KotlinTable?
    fun getList(wrapper: KotlinTableWrapper, type: String): List<KotlinTable>?
    fun getPage(wrapper: KotlinTableWrapper, page: Int, size: Int, type: String): Pagination<KotlinTable>?
    fun deleteData(id: Array<Long>, type: String)

    enum class DaoType {
        PLUS,
        FLUENT,
        JPA
        ;
        companion object{
            fun getType(type: String):String {
                for (value in values()) {
                    if (value.name.lowercase() == type.lowercase()) {
                        return value.name
                    }

                }
                throw IllegalArgumentException(type)
            }
        }
    }
}