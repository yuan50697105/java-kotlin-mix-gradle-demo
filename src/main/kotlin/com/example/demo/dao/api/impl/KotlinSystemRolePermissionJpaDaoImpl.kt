package com.example.demo.dao.api.impl

import com.example.demo.constants.KotlinDaoType
import com.example.demo.dao.api.KotlinSystemRolePermissionDao
import com.example.demo.entity.KotlinSystemRolePermission
import com.example.demo.repository.KotlinSystemRolePermissionRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class KotlinSystemRolePermissionJpaDaoImpl(private val repository: KotlinSystemRolePermissionRepository) :
    KotlinSystemRolePermissionDao {
    override fun getType(): String {
        return KotlinDaoType.JPA.name
    }

    @Transactional
    override fun updateData(kotlinTable: KotlinSystemRolePermission) {
        repository.save(kotlinTable)
    }

    override fun get(id: Long): KotlinSystemRolePermission {
        return repository.findById(id).orElse(null)
    }

    @Transactional
    override fun deleteData(id: Array<Long>) {
        this.repository.deleteAllById(id.asList())
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
        this.repository.deleteByRoleId(roleId)
        this.saveData(roleId, permissionIds)
    }

    @Transactional
    override fun deleteDataByRoleIds(roleIds: Array<Long>) {
        this.repository.deleteByRoleIdIn(roleIds.asList())
    }

    @Transactional
    override fun saveData(kotlinTable: List<KotlinSystemRolePermission>) {
        this.repository.saveAll(kotlinTable)
    }

    @Transactional
    override fun saveData(kotlinTable: KotlinSystemRolePermission) {
        repository.save(kotlinTable)
    }
}