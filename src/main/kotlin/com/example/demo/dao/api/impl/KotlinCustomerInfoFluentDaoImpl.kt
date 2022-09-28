package com.example.demo.dao.api.impl

import cn.org.atool.fluent.mybatis.base.IBaseDao
import com.example.demo.constants.JavaDaoType
import com.example.demo.dao.api.KotlinCustomerInfoDao
import com.example.demo.dao.base.KotlinCustomerInfoBaseDao
import com.example.demo.entity.KotlinCustomerInfo
import com.example.demo.entity.dto.KotlinCustomerInfoWrapper
import com.example.demo.entity.dto.Pagination
import com.github.pagehelper.PageHelper
import com.github.pagehelper.PageInfo
import com.google.common.collect.Lists
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.*

@Service
class KotlinCustomerInfoFluentDaoImpl : KotlinCustomerInfoBaseDao(), KotlinCustomerInfoDao,
    IBaseDao<KotlinCustomerInfo?> {
    override fun getType(): String {
        return JavaDaoType.FLUENT.name
    }

    @Transactional
    override fun saveData(javaSystemRole: KotlinCustomerInfo) {
        this.save<Any>(javaSystemRole)
    }

    @Transactional
    override fun updateData(javaSystemRole: KotlinCustomerInfo) {
        updateById(javaSystemRole)
    }

    override operator fun get(id: Long): KotlinCustomerInfo? {
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

    override fun getList(wrapper: KotlinCustomerInfoWrapper): List<KotlinCustomerInfo>? {
        return listEntity(query())
    }

    override fun getList(
        wrapper: KotlinCustomerInfoWrapper,
        page: Int,
        size: Int
    ): List<KotlinCustomerInfo>? {
        PageHelper.startPage<Any>(page, size)
        return getList(wrapper)
    }

    override fun getPage(
        wrapper: KotlinCustomerInfoWrapper,
        page: Int,
        size: Int
    ): Pagination<KotlinCustomerInfo>? {
        PageHelper.startPage<Any>(page, size)
        return Pagination(PageInfo(getList(wrapper)))
    }
}