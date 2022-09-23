package com.example.demo.dao

import com.example.demo.entity.KotlinTable

interface KotlinTableDao {
    fun getType(): String
    fun saveData(kotlinTable: KotlinTable)

}
