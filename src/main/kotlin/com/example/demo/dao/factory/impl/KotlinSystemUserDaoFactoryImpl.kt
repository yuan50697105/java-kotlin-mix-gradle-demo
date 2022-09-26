package com.example.demo.dao.factory.impl

import com.example.demo.constants.KotlinDaoType
import com.example.demo.dao.KotlinSystemUserDao
import com.example.demo.dao.factory.KotlinSystemUserDaoFactory
import com.example.demo.entity.KotlinSystemUser
import com.example.demo.entity.dto.KotlinSystemUserWrapper
import com.example.demo.entity.dto.Pagination
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.function.Function
import java.util.stream.Collectors

@Service
class KotlinSystemUserDaoFactoryImpl @Autowired constructor(kotlinTableDao: List<KotlinSystemUserDao>) :
    KotlinSystemUserDaoFactory {
    private val kotlinTableDaoMap: Map<String, KotlinSystemUserDao>

    init {
        this.kotlinTableDaoMap =
            kotlinTableDao.stream().collect(Collectors.toMap(KotlinSystemUserDao::getType, Function.identity()))
    }

    override fun updateData(convertForUpdate: KotlinSystemUser, type: String) {
        kotlinTableDao(type)?.updateData(convertForUpdate)
    }

    override fun get(id: Long, type: String): KotlinSystemUser? {
        return kotlinTableDao(type)?.get(id)
    }

    override fun deleteData(id: Array<Long>, type: String) {
        kotlinTableDao(type)?.deleteData(id)
    }

    override fun getList(wrapper: KotlinSystemUserWrapper, type: String): List<KotlinSystemUser>? {
        return kotlinTableDao(type)?.getList(wrapper)
    }

    override fun getPage(
        wrapper: KotlinSystemUserWrapper,
        page: Int,
        size: Int,
        type: String
    ): Pagination<KotlinSystemUser>? {
        return kotlinTableDao(type)?.getPage(wrapper, page, size)
    }

    override fun saveData(kotlinTable: KotlinSystemUser, type: String) {
        kotlinTableDao(type)?.saveData(kotlinTable)
    }

    private fun kotlinTableDao(type: String) = kotlinTableDaoMap[KotlinDaoType.getType(type)]
}