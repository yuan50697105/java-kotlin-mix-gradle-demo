package com.example.demo.dao.factory.impl

import cn.hutool.core.util.ObjUtil
import com.example.demo.constants.JavaDaoType
import com.example.demo.dao.KotlinSystemUserDepartmentDao
import com.example.demo.dao.factory.KotlinSystemUserDepartmentDaoFactory
import com.example.demo.entity.KotlinSystemUserDepartment
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.function.Function
import java.util.stream.Collectors

@Service
class KotlinSystemUserDepartmentDaoFactoryImpl @Autowired constructor(systemUserDaoList: List<KotlinSystemUserDepartmentDao>) :
    KotlinSystemUserDepartmentDaoFactory {
    private val daoMap: Map<String, KotlinSystemUserDepartmentDao>

    init {
        daoMap = systemUserDaoList.stream().collect(
            Collectors.toMap(
                { obj: KotlinSystemUserDepartmentDao -> obj.getType() }, Function.identity()
            )
        )
    }

    @Transactional
    override fun saveData(type: String, data: KotlinSystemUserDepartment) {
        getKotlinSystemUserDepartmentDao(type)?.saveData(data)
    }

    @Transactional
    override fun updateData(type: String, data: KotlinSystemUserDepartment) {
        getKotlinSystemUserDepartmentDao(type)?.updateData(data)
    }

    override fun get(type: String, id: Long): KotlinSystemUserDepartment? {
        return getKotlinSystemUserDepartmentDao(type)?.get(id)
    }

    @Transactional
    override fun deleteData(type: String, ids: Array<Long>) {
        getKotlinSystemUserDepartmentDao(type)?.deleteData(ids)
    }

    @Transactional
    override fun deleteData(type: String, ids: Collection<Long>) {
        getKotlinSystemUserDepartmentDao(type)?.deleteData(ids)
    }

    @Transactional
    override fun deleteData(type: String, id: Long, vararg ids: Long) {
        getKotlinSystemUserDepartmentDao(type)?.deleteData(
            com.google.common.collect.Lists.asList(
                id,
                ids.toTypedArray()
            )
        )
    }

    override fun saveData(type: String, userId: Long?, departIds: List<Long>?) {
        if (userId != null && departIds != null) {
            getKotlinSystemUserDepartmentDao(type)?.saveData(userId, departIds)
        }
    }


    @Transactional
    override fun updateData(type: String, userId: Long?, departIds: List<Long>?) {
        if (userId != null && departIds != null) {
            getKotlinSystemUserDepartmentDao(type)?.updateData(userId, departIds)
        }
    }

    @Transactional
    override fun deleteDataByUserIds(type: String, userIds: Array<Long>) {
        getKotlinSystemUserDepartmentDao(type)?.deleteDataByUserIds(userIds)
    }

    @Transactional
    override fun deleteDataByDepartIds(type: String, id: Array<Long>) {
        getKotlinSystemUserDepartmentDao(type)?.deleteDataByDepartIds(id)
    }

    private fun getKotlinSystemUserDepartmentDao(type: String): KotlinSystemUserDepartmentDao? {
        val javaSystemUserDao = daoMap[JavaDaoType.getType(type)]
        return if (ObjUtil.isNotEmpty(javaSystemUserDao)) {
            javaSystemUserDao
        } else {
            throw IllegalArgumentException(type)
        }
    }
}