package com.example.demo.dao.factory.impl

import com.example.demo.constants.KotlinDaoType
import com.example.demo.dao.api.KotlinTableDao
import com.example.demo.dao.factory.KotlinTableDaoFactory
import com.example.demo.entity.KotlinTable
import com.example.demo.entity.dto.KotlinTableWrapper
import com.example.demo.entity.dto.Pagination
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.function.Function
import java.util.stream.Collectors

@Service
class KotlinTableDaoFactoryImpl @Autowired constructor(kotlinTableDao: List<KotlinTableDao>) : KotlinTableDaoFactory {
    private val kotlinTableDaoMap: Map<String, KotlinTableDao>

    init {
        this.kotlinTableDaoMap =
            kotlinTableDao.stream().collect(Collectors.toMap(KotlinTableDao::getType, Function.identity()))
    }

    override fun updateData(convertForUpdate: KotlinTable, type: String) {
        kotlinTableDao(type)?.updateData(convertForUpdate)
    }

    override fun get(id: Long, type: String): KotlinTable? {
        return kotlinTableDao(type)?.get(id)
    }

    override fun deleteData(id: Array<Long>, type: String) {
        kotlinTableDao(type)?.deleteData(id)
    }

    override fun getList(wrapper: KotlinTableWrapper, type: String): List<KotlinTable>? {
        return kotlinTableDao(type)?.getList(wrapper)
    }

    override fun getPage(wrapper: KotlinTableWrapper, page: Int, size: Int, type: String): Pagination<KotlinTable>? {
        return kotlinTableDao(type)?.getPage(wrapper, page, size)
    }

    override fun saveData(kotlinTable: KotlinTable, type: String) {
        kotlinTableDao(type)?.saveData(kotlinTable)
    }

    private fun kotlinTableDao(type: String) = kotlinTableDaoMap[KotlinDaoType.getType(type)]
}