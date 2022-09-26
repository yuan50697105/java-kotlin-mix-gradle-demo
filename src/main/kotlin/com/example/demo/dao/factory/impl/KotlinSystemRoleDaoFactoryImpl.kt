package com.example.demo.dao.factory.impl

import com.example.demo.constants.KotlinDaoType
import com.example.demo.dao.KotlinSystemRoleDao
import com.example.demo.dao.factory.KotlinSystemRoleDaoFactory
import com.example.demo.entity.KotlinSystemRole
import com.example.demo.entity.dto.KotlinSystemRoleWrapper
import com.example.demo.entity.dto.Pagination
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.function.Function
import java.util.stream.Collectors

@Service
class KotlinSystemRoleDaoFactoryImpl @Autowired constructor(kotlinTableDao: List<KotlinSystemRoleDao>) :
    KotlinSystemRoleDaoFactory {
    private val kotlinTableDaoMap: Map<String, KotlinSystemRoleDao>

    init {
        this.kotlinTableDaoMap =
            kotlinTableDao.stream().collect(Collectors.toMap(KotlinSystemRoleDao::getType, Function.identity()))
    }

    override fun updateData(convertForUpdate: KotlinSystemRole, type: String) {
        kotlinTableDao(type)?.updateData(convertForUpdate)
    }

    override fun get(id: Long, type: String): KotlinSystemRole? {
        return kotlinTableDao(type)?.get(id)
    }

    override fun deleteData(id: Array<Long>, type: String) {
        kotlinTableDao(type)?.deleteData(id)
    }

    override fun getList(wrapper: KotlinSystemRoleWrapper, type: String): List<KotlinSystemRole>? {
        return kotlinTableDao(type)?.getList(wrapper)
    }

    override fun getPage(
        wrapper: KotlinSystemRoleWrapper,
        page: Int,
        size: Int,
        type: String
    ): Pagination<KotlinSystemRole>? {
        return kotlinTableDao(type)?.getPage(wrapper, page, size)
    }

    override fun saveData(kotlinTable: KotlinSystemRole, type: String) {
        kotlinTableDao(type)?.saveData(kotlinTable)
    }

    private fun kotlinTableDao(type: String) = kotlinTableDaoMap[KotlinDaoType.getType(type)]
}