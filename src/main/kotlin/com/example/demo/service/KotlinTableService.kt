package com.example.demo.service

import com.example.demo.entity.KotlinTable

interface KotlinTableService {
    fun saveData(kotlinTable: KotlinTable, type: String)

}
