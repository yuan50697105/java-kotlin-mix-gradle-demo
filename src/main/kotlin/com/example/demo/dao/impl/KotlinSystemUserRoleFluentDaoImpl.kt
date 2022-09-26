package com.example.demo.dao.impl

import com.example.demo.constants.KotlinDaoType
import com.example.demo.dao.KotlinSystemUserRoleDao
import com.example.demo.dao.base.KotlinSystemUserRoleBaseDao
import com.example.demo.entity.KotlinSystemUserRole
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class KotlinSystemUserRoleFluentDaoImpl : KotlinSystemUserRoleBaseDao(), KotlinSystemUserRoleDao {
    override fun getType(): String {
        return KotlinDaoType.FLUENT.name
    }

    @Transactional
    override fun updateData(kotlinTable: KotlinSystemUserRole) {
        this.updateById(kotlinTable)
    }

    override fun get(id: Long): KotlinSystemUserRole {
        return selectById(id)
    }


    @Transactional
    override fun deleteData(id: Array<Long>) {
        deleteByIds(id.asList())
    }

    @Transactional
    override fun saveData(kotlinTable: KotlinSystemUserRole) {
        this.save<KotlinSystemUserRole>(kotlinTable)
    }

    @Transactional
    override fun saveData(kotlinTable: List<KotlinSystemUserRole>) {
        this.save(kotlinTable)
    }

    @Transactional
    override fun updateData(userId: Long, roleIds: List<Long>) {
        this.deleteBy(query().where.userId().eq(userId).end())
        val map = roleIds.map {
            val kotlinSystemUserRole = KotlinSystemUserRole()
            kotlinSystemUserRole.roleId = it
            kotlinSystemUserRole.userId = userId
            kotlinSystemUserRole
        }
        this.saveData(map)
    }

    @Transactional
    override fun deleteDataByUserIds(userIds: Array<Long>) {
        this.deleteBy(query().where.userId().`in`(userIds).end())

    }

    @Transactional
    override fun deleteDataByRoleIds(roleIds: Array<Long>) {
        this.deleteBy(query().where.roleId().`in`(roleIds).end())
    }
}