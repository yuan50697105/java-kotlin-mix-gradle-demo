package com.example.demo.dao.api.impl

import cn.org.atool.fluent.mybatis.base.IBaseDao
import com.example.demo.constants.JavaDaoType
import com.example.demo.dao.api.KotlinOrderInfoDao
import com.example.demo.dao.base.KotlinOrderInfoBaseDao
import com.example.demo.entity.KotlinOrderInfo
import com.example.demo.entity.dto.KotlinOrderInfoWrapper
import com.example.demo.entity.dto.Pagination
import com.github.pagehelper.PageHelper
import com.github.pagehelper.PageInfo
import com.google.common.collect.Lists
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.*

@Service
class KotlinOrderInfoFluentDaoImpl : KotlinOrderInfoBaseDao(), KotlinOrderInfoDao,
    IBaseDao<KotlinOrderInfo?> {
    override fun getType(): String {
        return JavaDaoType.FLUENT.name
    }

    @Transactional
    override fun saveData(javaSystemRole: KotlinOrderInfo) {
        this.save<Any>(javaSystemRole)
    }

    @Transactional
    override fun updateData(javaSystemRole: KotlinOrderInfo) {
        updateById(javaSystemRole)
    }

    override operator fun get(id: Long): KotlinOrderInfo? {
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

    override fun getList(wrapper: KotlinOrderInfoWrapper): List<KotlinOrderInfo>? {
        return listEntity(query())
    }

    override fun getList(
        wrapper: KotlinOrderInfoWrapper,
        page: Int,
        size: Int
    ): List<KotlinOrderInfo>? {
        PageHelper.startPage<Any>(page, size)
        return getList(wrapper)
    }

    override fun getPage(
        wrapper: KotlinOrderInfoWrapper,
        page: Int,
        size: Int
    ): Pagination<KotlinOrderInfo>? {
        PageHelper.startPage<Any>(page, size)
        return Pagination(PageInfo(getList(wrapper)))
    }
}