package com.example.demo.service.impl

import com.example.demo.entity.KotlinTable
import com.example.demo.service.KotlinTableDaoFactory
import com.example.demo.service.KotlinTableService
import org.springframework.stereotype.Service
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory

@Service
class KotlinTableServiceImpl(private val kotlinTableDaoFactory: KotlinTableDaoFactory) : KotlinTableService {
    override fun saveData(kotlinTable: KotlinTable, type: String) {
        kotlinTableDaoFactory.saveData(kotlinTable, type)
    }
}