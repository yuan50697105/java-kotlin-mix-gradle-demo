package com.example.demo.dao.impl

import com.example.demo.constants.JavaDaoType
import com.example.demo.dao.KotlinSystemUserDepartmentDao
import com.example.demo.entity.KotlinSystemUserDepartment
import com.example.demo.repository.KotlinSystemUserDepartmentRepository
import com.google.common.collect.Lists
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class KotlinSystemUserDepartmentJpaDaoImpl(private val repository: KotlinSystemUserDepartmentRepository) :
    KotlinSystemUserDepartmentDao {
    override fun getType(): String {
        return JavaDaoType.JPA.name
    }

    @Transactional
    override fun saveData(javaSystemRole: KotlinSystemUserDepartment) {
        repository.save(javaSystemRole)
    }

    override fun updateData(javaSystemRole: KotlinSystemUserDepartment) {
        repository.save(javaSystemRole)
    }

    override fun get(id: Long): KotlinSystemUserDepartment {
        return repository.findById(id).orElse(null)
    }

    @Transactional
    override fun deleteData(ids: Array<Long>) {
        this.deleteData(listOf(*ids))
    }

    @Transactional
    override fun deleteData(ids: Collection<Long>) {
        repository.deleteAllById(ids)
    }

    override fun deleteData(id: Long, vararg ids: Long) {
        this.deleteData(Lists.asList(id, ids.toTypedArray()))
    }

    @Transactional
    override fun saveData(userId: Long, departIds: List<Long>) {
        val arrayList = ArrayList<KotlinSystemUserDepartment>()
        for (departId in departIds) {
            val element = KotlinSystemUserDepartment()
            element.userId = userId
            element.departId = departId
            arrayList.add(element)
        }
        repository.saveAll(arrayList)
    }

    @Transactional
    override fun updateData(userId: Long, departIds: List<Long>) {
        repository.deleteByUserId(userId)
        saveData(userId, departIds)
    }

    @Transactional
    override fun deleteDataByUserIds(userIds: Array<Long>) {
        repository.deleteByUserIdIn(userIds.toList())
    }

    @Transactional
    override fun deleteDataByDepartIds(departIds: Array<Long>) {
        repository.deleteByDepartIdIn(departIds.toMutableList())
    }
}