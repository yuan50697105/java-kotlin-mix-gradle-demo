package com.example.demo.dao.api.impl

import com.baomidou.mybatisplus.extension.service.IService
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl
import com.example.demo.constants.JavaDaoType
import com.example.demo.dao.api.KotlinSystemUserDepartmentDao
import com.example.demo.entity.KotlinSystemUserDepartment
import com.example.demo.mapper.KotlinSystemUserDepartmentDaoMapper
import com.google.common.collect.Lists
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class KotlinSystemUserDepartmentPlusDaoImpl :
    ServiceImpl<KotlinSystemUserDepartmentDaoMapper, KotlinSystemUserDepartment>(),
    KotlinSystemUserDepartmentDao, IService<KotlinSystemUserDepartment> {
    override fun getType(): String {
        return JavaDaoType.PLUS.name
    }

    @Transactional
    override fun saveData(javaSystemRole: KotlinSystemUserDepartment) {
        save(javaSystemRole)
    }

    @Transactional
    override fun updateData(javaSystemRole: KotlinSystemUserDepartment) {
        this.updateById(javaSystemRole)
    }

    override operator fun get(id: Long): KotlinSystemUserDepartment {
        return getById(id)
    }

    @Transactional
    override fun deleteData(ids: Array<Long>) {
        this.deleteData(listOf(*ids))
    }

    @Transactional
    override fun deleteData(ids: Collection<Long>) {
        removeByIds(ids)
    }

    @Transactional
    override fun deleteData(id: Long, vararg ids: Long) {
        val asList = Lists.asList(id, ids.toTypedArray())
        this.deleteData(asList)
    }

    @Transactional
    override fun saveData(userId: Long, departIds: List<Long>) {
        val arrayList = ArrayList<KotlinSystemUserDepartment>()
        for (departId in departIds) {
            val element = KotlinSystemUserDepartment()
            element.departId = departId
            element.userId = userId
            arrayList.add(element)
        }
        saveBatch(arrayList)
    }

    @Transactional
    override fun updateData(userId: Long, departIds: List<Long>) {
        ktUpdate().eq(KotlinSystemUserDepartment::userId, userId).remove()
        saveData(userId, departIds)
    }

    @Transactional
    override fun deleteDataByUserIds(userIds: Array<Long>) {
        ktUpdate().`in`(KotlinSystemUserDepartment::userId, userIds.toList()).remove()
    }

    @Transactional
    override fun deleteDataByDepartIds(departIds: Array<Long>) {
        ktUpdate().`in`(KotlinSystemUserDepartment::departId, departIds.toList()).remove()
    }
}