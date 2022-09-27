package com.example.demo.dao.factory.impl

import cn.hutool.core.util.ObjUtil
import com.example.demo.constants.JavaDaoType
import com.example.demo.dao.KotlinSystemDepartmentDao
import com.example.demo.dao.factory.KotlinSystemDepartmentDaoFactory
import com.example.demo.entity.KotlinSystemDepartment
import com.example.demo.entity.dto.KotlinSystemDepartmentWrapper
import com.example.demo.entity.dto.Pagination
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.function.Function
import java.util.stream.Collectors

@Service
class KotlinSystemDepartmentDaoFactoryImpl @Autowired constructor(systemUserDaoList: List<KotlinSystemDepartmentDao>) :
    KotlinSystemDepartmentDaoFactory {
    private val daoMap: Map<String, KotlinSystemDepartmentDao>

    init {
        daoMap = systemUserDaoList.stream().collect(
            Collectors.toMap(
                { obj: KotlinSystemDepartmentDao -> obj.getType() }, Function.identity()
            )
        )
    }

    @Transactional
    override fun saveData(type: String, data: KotlinSystemDepartment) {
        getKotlinSystemDepartmentDao(type)?.saveData(data)
    }

    @Transactional
    override fun updateData(type: String, data: KotlinSystemDepartment) {
        getKotlinSystemDepartmentDao(type)?.updateData(data)
    }

    override fun get(type: String, id: Long): KotlinSystemDepartment? {
        return getKotlinSystemDepartmentDao(type)?.get(id)
    }

    @Transactional
    override fun deleteData(type: String, ids: Array<Long>) {
        getKotlinSystemDepartmentDao(type)?.deleteData(ids)
    }

    @Transactional
    override fun deleteData(type: String, ids: Collection<Long>) {
        getKotlinSystemDepartmentDao(type)?.deleteData(ids)
    }

    @Transactional
    override fun deleteData(type: String, id: Long, vararg ids: Long) {
        getKotlinSystemDepartmentDao(type)?.deleteData(com.google.common.collect.Lists.asList(id, ids.toTypedArray()))
    }

    override fun getList(type: String, wrapper: KotlinSystemDepartmentWrapper): List<KotlinSystemDepartment>? {
        return getKotlinSystemDepartmentDao(type)?.getList(wrapper)
    }

    override fun getList(
        type: String,
        wrapper: KotlinSystemDepartmentWrapper,
        page: Int,
        size: Int
    ): List<KotlinSystemDepartment>? {
        return getKotlinSystemDepartmentDao(type)?.getList(wrapper, page, size)
    }

    override fun getPage(
        type: String,
        wrapper: KotlinSystemDepartmentWrapper,
        page: Int,
        size: Int
    ): Pagination<KotlinSystemDepartment>? {
        return getKotlinSystemDepartmentDao(type)?.getPage(wrapper, page, size)
    }

    private fun getKotlinSystemDepartmentDao(type: String): KotlinSystemDepartmentDao? {
        val javaSystemUserDao = daoMap[JavaDaoType.getType(type)]
        return if (ObjUtil.isNotEmpty(javaSystemUserDao)) {
            javaSystemUserDao
        } else {
            throw IllegalArgumentException(type)
        }
    }
}