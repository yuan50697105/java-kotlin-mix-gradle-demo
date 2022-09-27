package com.example.demo.dao.impl

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl
import com.example.demo.constants.KotlinDaoType
import com.example.demo.dao.KotlinSystemRolePermissionDao
import com.example.demo.entity.KotlinSystemRolePermission
import com.example.demo.mapper.KotlinSystemRolePermissionDaoMapper
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class KotlinSystemRolePermissionPlusDaoImpl :
    ServiceImpl<KotlinSystemRolePermissionDaoMapper, KotlinSystemRolePermission>(),
    KotlinSystemRolePermissionDao {
    override fun getType(): String {
        return KotlinDaoType.PLUS.name
    }

    @Transactional
    override fun updateData(kotlinTable: KotlinSystemRolePermission) {
        this.updateById(kotlinTable)
    }

    override fun get(id: Long): KotlinSystemRolePermission {
        return getById(id)
    }

    @Transactional
    override fun deleteData(id: Array<Long>) {
        this.removeByIds(id.asList())
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
        this.ktUpdate().eq(KotlinSystemRolePermission::roleId, roleId).remove()
        this.saveData(roleId, permissionIds)
    }

    @Transactional
    override fun deleteDataByRoleIds(roleIds: Array<Long>) {
        ktUpdate().`in`(KotlinSystemRolePermission::roleId, roleIds).remove()
    }

    @Transactional
    override fun saveData(kotlinTable: List<KotlinSystemRolePermission>) {
        this.saveBatch(kotlinTable)
    }

    @Transactional
    override fun saveData(kotlinTable: KotlinSystemRolePermission) {
        this.save(kotlinTable)
    }

}