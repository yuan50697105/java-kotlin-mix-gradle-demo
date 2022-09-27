package com.example.demo.dao.impl

import com.example.demo.constants.KotlinDaoType
import com.example.demo.dao.KotlinSystemRolePermissionDao
import com.example.demo.dao.base.KotlinSystemRolePermissionBaseDao
import com.example.demo.entity.KotlinSystemRolePermission
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class KotlinSystemRolePermissionFluentDaoImpl : KotlinSystemRolePermissionBaseDao(), KotlinSystemRolePermissionDao {
    override fun getType(): String {
        return KotlinDaoType.FLUENT.name
    }

    @Transactional
    override fun updateData(kotlinTable: KotlinSystemRolePermission) {
        this.updateById(kotlinTable)
    }

    override fun get(id: Long): KotlinSystemRolePermission {
        return selectById(id)
    }

    @Transactional
    override fun deleteData(id: Array<Long>) {
        deleteByIds(id.asList())
    }

    @Transactional
    override fun saveData(kotlinTable: KotlinSystemRolePermission) {
        this.save<KotlinSystemRolePermission>(kotlinTable)
    }

    @Transactional
    override fun saveData(roleId: Long, permissionIds: List<Long>) {
        val kotlinTable = ArrayList<KotlinSystemRolePermission>(permissionIds.size)
        for (permissionId in permissionIds) {
            val element = KotlinSystemRolePermission()
            element.roleId = roleId
            element.permissionId = permissionId
            kotlinTable.add(element)
        }
        this.saveData(kotlinTable)
    }

    @Transactional
    override fun updateData(roleId: Long, permissionIds: List<Long>) {
        this.deleteBy(query().where.roleId().eq(roleId).end())
        this.saveData(roleId, permissionIds)
    }

    @Transactional
    override fun saveData(kotlinTable: List<KotlinSystemRolePermission>) {
        this.save(kotlinTable)
    }

    @Transactional
    override fun deleteDataByRoleIds(roleIds: Array<Long>) {
        this.deleteBy(query().where.roleId().`in`(roleIds).end())
    }
}