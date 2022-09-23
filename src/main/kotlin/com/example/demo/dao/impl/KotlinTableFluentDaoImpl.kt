package com.example.demo.dao.impl

import com.example.demo.dao.KotlinTableDao
import com.example.demo.dao.base.KotlinTableBaseDao
import com.example.demo.entity.KotlinTable
import com.example.demo.service.KotlinTableDaoFactory
import org.springframework.stereotype.Service
import javax.transaction.Transactional

@Service
class KotlinTableFluentDaoImpl : KotlinTableBaseDao(), KotlinTableDao {
    override fun getType(): String {
        return KotlinTableDaoFactory.DaoType.FLUENT.name
    }

    @Transactional
    override fun saveData(kotlinTable: KotlinTable) {
        this.save<KotlinTable>(kotlinTable)
    }
}