package com.example.demo.service.impl

import com.example.demo.dao.KotlinTableDao
import com.example.demo.entity.KotlinTable
import com.example.demo.service.KotlinTableDaoFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.function.Function
import java.util.stream.Collectors

@Service
class KotlinTableDaoFactoryImpl @Autowired constructor(kotlinTableDao: List<KotlinTableDao>) : KotlinTableDaoFactory {
    private val kotlinTableDaoMap:Map<String, KotlinTableDao>

    init {
        this.kotlinTableDaoMap =
            kotlinTableDao.stream().collect(Collectors.toMap(KotlinTableDao::getType, Function.identity()))
    }

    override fun saveData(kotlinTable: KotlinTable, type: String) {
        kotlinTableDaoMap[KotlinTableDaoFactory.DaoType.getType(type)]?.saveData(kotlinTable)
    }
}