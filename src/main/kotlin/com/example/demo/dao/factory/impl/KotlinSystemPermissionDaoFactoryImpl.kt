package com.example.demo.dao.factory.impl

import com.example.demo.constants.KotlinDaoType
import com.example.demo.dao.api.KotlinSystemPermissionDao
import com.example.demo.dao.factory.KotlinSystemPermissionDaoFactory
import com.example.demo.entity.KotlinSystemPermission
import com.example.demo.entity.dto.KotlinSystemPermissionWrapper
import com.example.demo.entity.dto.Pagination
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.function.Function
import java.util.stream.Collectors

@Service
class KotlinSystemPermissionDaoFactoryImpl @Autowired constructor(kotlinTableDao: List<KotlinSystemPermissionDao>) :
    KotlinSystemPermissionDaoFactory {
    private val kotlinTableDaoMap: Map<String, KotlinSystemPermissionDao>

    init {
        this.kotlinTableDaoMap =
            kotlinTableDao.stream().collect(Collectors.toMap(KotlinSystemPermissionDao::getType, Function.identity()))
    }

    @Transactional
    override fun updateData(convertForUpdate: KotlinSystemPermission, type: String) {
        kotlinTableDao(type)?.updateData(convertForUpdate)
    }

    override fun get(id: Long, type: String): KotlinSystemPermission? {
        return kotlinTableDao(type)?.get(id)
    }

    @Transactional
    override fun deleteData(id: Array<Long>, type: String) {
        kotlinTableDao(type)?.deleteData(id)
    }

    override fun getList(wrapper: KotlinSystemPermissionWrapper, type: String): List<KotlinSystemPermission>? {
        return kotlinTableDao(type)?.getList(wrapper)
    }

    override fun getPage(
        wrapper: KotlinSystemPermissionWrapper,
        page: Int,
        size: Int,
        type: String
    ): Pagination<KotlinSystemPermission>? {
        return kotlinTableDao(type)?.getPage(wrapper, page, size)
    }

    override fun saveData(kotlinTable: KotlinSystemPermission, type: String) {
        kotlinTableDao(type)?.saveData(kotlinTable)
    }

    private fun kotlinTableDao(type: String) = kotlinTableDaoMap[KotlinDaoType.getType(type)]
}