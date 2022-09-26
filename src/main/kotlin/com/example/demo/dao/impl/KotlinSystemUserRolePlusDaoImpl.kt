package com.example.demo.dao.impl

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl
import com.example.demo.constants.KotlinDaoType
import com.example.demo.dao.KotlinSystemUserRoleDao
import com.example.demo.entity.KotlinSystemUserRole
import com.example.demo.mapper.KotlinSystemUserRoleDaoMapper
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class KotlinSystemUserRolePlusDaoImpl : ServiceImpl<KotlinSystemUserRoleDaoMapper, KotlinSystemUserRole>(),
    KotlinSystemUserRoleDao {
    override fun getType(): String {
        return KotlinDaoType.PLUS.name
    }

    @Transactional
    override fun updateData(kotlinTable: KotlinSystemUserRole) {
        this.updateById(kotlinTable)
    }

    override fun get(id: Long): KotlinSystemUserRole {
        return getById(id)
    }

    @Transactional
    override fun deleteData(id: Array<Long>) {
        this.removeByIds(id.asList())
    }

    @Transactional
    override fun saveData(kotlinTable: List<KotlinSystemUserRole>) {
        this.saveBatch(kotlinTable)
    }

    @Transactional
    override fun updateData(userId: Long, roleIds: List<Long>) {
        ktUpdate().eq(KotlinSystemUserRole::userId, userId).remove()
        val map = roleIds.map {
            val kotlinSystemUserRole = KotlinSystemUserRole()
            kotlinSystemUserRole.roleId = it
            kotlinSystemUserRole.userId = userId
            kotlinSystemUserRole
        }
        saveData(map)
    }

    @Transactional
    override fun deleteDataByUserIds(userIds: Array<Long>) {
        this.ktUpdate().`in`(KotlinSystemUserRole::userId, userIds.asList()).remove()
    }

    @Transactional
    override fun deleteDataByRoleIds(roleIds: Array<Long>) {
        this.ktUpdate().`in`(KotlinSystemUserRole::roleId, roleIds.asList()).remove()
    }

    @Transactional
    override fun saveData(kotlinTable: KotlinSystemUserRole) {
        this.save(kotlinTable)
    }
}