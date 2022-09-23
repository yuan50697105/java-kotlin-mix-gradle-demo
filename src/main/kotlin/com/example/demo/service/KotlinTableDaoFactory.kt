package com.example.demo.service

import com.example.demo.entity.KotlinTable

interface KotlinTableDaoFactory {
    fun saveData(kotlinTable: KotlinTable, type: String)
    enum class DaoType {
        PLUS,
        FLUENT,
        ;
        companion object{
            fun getType(type: String):String {
                for (value in values()) {
                    if (value.name == type) {
                        return value.name
                    }

                }
                throw IllegalArgumentException(type)
            }
        }
    }
}