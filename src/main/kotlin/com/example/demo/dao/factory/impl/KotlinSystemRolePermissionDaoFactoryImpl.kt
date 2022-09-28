package com.example.demo.dao.factory.impl

import com.example.demo.constants.KotlinDaoType
import com.example.demo.dao.api.KotlinSystemRolePermissionDao
import com.example.demo.dao.factory.KotlinSystemRolePermissionDaoFactory
import com.example.demo.entity.KotlinSystemRolePermission
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.function.Function
import java.util.stream.Collectors

@Service
class KotlinSystemRolePermissionDaoFactoryImpl @Autowired constructor(kotlinTableDao: List<KotlinSystemRolePermissionDao>) :
    KotlinSystemRolePermissionDaoFactory {
    private val kotlinTableDaoMap: Map<String, KotlinSystemRolePermissionDao>

    init {
        this.kotlinTableDaoMap =
            kotlinTableDao.stream()
                .collect(Collectors.toMap(KotlinSystemRolePermissionDao::getType, Function.identity()))
    }

    @Transactional
    override fun updateData(type: String, kotlinSystemRolePermission: KotlinSystemRolePermission) {
        kotlinTableDao(type)?.updateData(kotlinSystemRolePermission)
    }

    override fun get(type: String, id: Long): KotlinSystemRolePermission? {
        return kotlinTableDao(type)?.get(id)
    }

    @Transactional
    override fun deleteData(type: String, id: Array<Long>) {
        kotlinTableDao(type)?.deleteData(id)
    }

    @Transactional
    override fun saveData(type: String, kotlinTable: KotlinSystemRolePermission) {
        kotlinTableDao(type)?.saveData(kotlinTable)
    }

    @Transactional
    override fun saveData(type: String, roleId: Long?, permissionIds: List<Long>?) {
        if (roleId != null && permissionIds != null) {
            this.kotlinTableDao(type)?.saveData(roleId, permissionIds)
        }
    }

    @Transactional
    override fun saveData(type: String, kotlinTable: List<KotlinSystemRolePermission>) {
        this.kotlinTableDao(type)?.saveData(kotlinTable)
    }

    @Transactional
    override fun updateData(type: String, roleId: Long?, permissionIds: List<Long>?) {
        if (roleId != null && permissionIds != null) {
            this.kotlinTableDao(type)?.updateData(roleId, permissionIds)
        }
    }

    @Transactional
    override fun deleteDataByRoleIds(type: String, roleIds: Array<Long>) {
        this.kotlinTableDao(type)?.deleteDataByRoleIds(roleIds)

    }

    private fun kotlinTableDao(type: String) = kotlinTableDaoMap[KotlinDaoType.getType(type)]
}