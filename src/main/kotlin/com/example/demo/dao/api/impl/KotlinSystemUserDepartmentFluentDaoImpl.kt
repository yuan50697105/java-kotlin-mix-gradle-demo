package com.example.demo.dao.api.impl

import cn.org.atool.fluent.mybatis.base.IBaseDao
import com.example.demo.constants.JavaDaoType
import com.example.demo.dao.api.KotlinSystemUserDepartmentDao
import com.example.demo.dao.base.KotlinSystemUserDepartmentBaseDao
import com.example.demo.entity.KotlinSystemUserDepartment
import com.google.common.collect.Lists
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.*

@Service
class KotlinSystemUserDepartmentFluentDaoImpl : KotlinSystemUserDepartmentBaseDao(), KotlinSystemUserDepartmentDao,
    IBaseDao<KotlinSystemUserDepartment?> {
    override fun getType(): String {
        return JavaDaoType.FLUENT.name
    }

    @Transactional
    override fun saveData(javaSystemRole: KotlinSystemUserDepartment) {
        this.save<Any>(javaSystemRole)
    }

    @Transactional
    override fun updateData(javaSystemRole: KotlinSystemUserDepartment) {
        updateById(javaSystemRole)
    }

    override operator fun get(id: Long): KotlinSystemUserDepartment? {
        return selectById(id)
    }

    @Transactional
    override fun deleteData(ids: Array<Long>) {
        deleteByIds(Arrays.asList(*ids))
    }

    @Transactional
    override fun deleteData(ids: Collection<Long>) {
        deleteByIds(ids)
    }

    @Transactional
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
        this.save(arrayList)
    }

    @Transactional
    override fun updateData(userId: Long, departIds: List<Long>) {
        deleteBy(query().where.userId().eq(userId).end())
        saveData(userId, departIds)
    }

    @Transactional
    override fun deleteDataByUserIds(userIds: Array<Long>) {
        deleteBy(query().where.userId().`in`(userIds.toList()).end())
    }

    @Transactional
    override fun deleteDataByDepartIds(departIds: Array<Long>) {
        deleteBy(query().where.departId().`in`(departIds).end())
    }
}