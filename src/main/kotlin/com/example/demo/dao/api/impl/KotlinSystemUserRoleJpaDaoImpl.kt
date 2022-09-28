package com.example.demo.dao.api.impl

import com.example.demo.constants.KotlinDaoType
import com.example.demo.dao.api.KotlinSystemUserRoleDao
import com.example.demo.entity.KotlinSystemUserRole
import com.example.demo.repository.KotlinSystemUserRoleRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class KotlinSystemUserRoleJpaDaoImpl(private val repository: KotlinSystemUserRoleRepository) :
    KotlinSystemUserRoleDao {
    override fun getType(): String {
        return KotlinDaoType.JPA.name
    }

    @Transactional
    override fun updateData(kotlinTable: KotlinSystemUserRole) {
        repository.save(kotlinTable)
    }

    override fun get(id: Long): KotlinSystemUserRole {
        return repository.findById(id).orElse(null)
    }

    @Transactional
    override fun saveData(kotlinTable: List<KotlinSystemUserRole>) {
        repository.saveAll(kotlinTable)
    }

    @Transactional
    override fun updateData(userId: Long, roleIds: List<Long>) {
        repository.deleteByUserId(userId)
        val map = roleIds.map {
            val kotlinSystemUserRole = KotlinSystemUserRole()
            kotlinSystemUserRole.roleId = it
            kotlinSystemUserRole.id = userId
            kotlinSystemUserRole
        }
        this.saveData(map)
    }

    @Transactional
    override fun deleteDataByUserIds(userIds: Array<Long>) {
        repository.deleteByUserIdIn(userIds.asList())
    }

    @Transactional
    override fun deleteDataByRoleIds(roleIds: Array<Long>) {
        repository.deleteByRoleIdIn(roleIds.asList())
    }

    override fun deleteData(id: Array<Long>) {
        repository.deleteAllById(id.asList())
    }

    @Transactional
    override fun saveData(kotlinTable: KotlinSystemUserRole) {
        repository.save(kotlinTable)
    }
}