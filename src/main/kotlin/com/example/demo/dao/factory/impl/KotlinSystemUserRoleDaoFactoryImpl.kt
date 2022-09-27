package com.example.demo.dao.factory.impl

import com.example.demo.constants.KotlinDaoType
import com.example.demo.dao.KotlinSystemUserRoleDao
import com.example.demo.dao.factory.KotlinSystemUserRoleDaoFactory
import com.example.demo.entity.KotlinSystemUserRole
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.function.Function
import java.util.stream.Collectors

@Service
class KotlinSystemUserRoleDaoFactoryImpl @Autowired constructor(kotlinTableDao: List<KotlinSystemUserRoleDao>) :
    KotlinSystemUserRoleDaoFactory {
    private val kotlinTableDaoMap: Map<String, KotlinSystemUserRoleDao>

    init {
        this.kotlinTableDaoMap =
            kotlinTableDao.stream().collect(Collectors.toMap(KotlinSystemUserRoleDao::getType, Function.identity()))
    }

    override fun updateData(convertForUpdate: KotlinSystemUserRole, type: String) {
        kotlinTableDao(type)?.updateData(convertForUpdate)
    }

    override fun get(id: Long, type: String): KotlinSystemUserRole? {
        return kotlinTableDao(type)?.get(id)
    }

    override fun deleteData(id: Array<Long>, type: String) {
        kotlinTableDao(type)?.deleteData(id)
    }

    override fun saveData(table: String, userId: Long?, roleIds: List<Long>?) {
        if (userId != null && roleIds != null) {

            val roles = roleIds.map {
                val element = KotlinSystemUserRole()
                element.roleId = it
                element.userId = userId
                element
            }
            this.kotlinTableDao(table)?.saveData(roles)
        }
    }

    @Transactional
    override fun updateData(type: String, userId: Long?, roleIds: List<Long>?) {
        if (userId != null && roleIds != null) {
            kotlinTableDao(type)?.updateData(userId, roleIds)
        }
    }

    @Transactional
    override fun deleteDataByUserIds(type: String, userIds: Array<Long>) {
        kotlinTableDao(type)?.deleteDataByUserIds(userIds)
    }

    @Transactional
    override fun deleteDataByRoleIds(type: String, roleIds: Array<Long>) {
        kotlinTableDao(type)?.deleteDataByRoleIds(roleIds)
    }

    override fun saveData(kotlinTable: KotlinSystemUserRole, type: String) {
        kotlinTableDao(type)?.saveData(kotlinTable)
    }

    private fun kotlinTableDao(type: String) = kotlinTableDaoMap[KotlinDaoType.getType(type)]
}