package com.example.demo.dao.impl

import com.example.demo.dao.KotlinTableDao
import com.example.demo.entity.KotlinTable
import com.example.demo.service.KotlinTableDaoFactory
import org.springframework.stereotype.Service

@Service
class KotlinTableJpaDaoImpl : KotlinTableDao {
    override fun getType(): String {
        return KotlinTableDaoFactory.DaoType.JPA.name
    }

    override fun saveData(kotlinTable: KotlinTable) {
        TODO("Not yet implemented")
    }
}