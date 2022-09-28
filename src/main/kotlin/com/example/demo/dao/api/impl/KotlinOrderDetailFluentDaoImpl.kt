package com.example.demo.dao.api.impl

import cn.org.atool.fluent.mybatis.base.IBaseDao
import com.example.demo.constants.JavaDaoType
import com.example.demo.dao.api.KotlinOrderDetailDao
import com.example.demo.dao.base.KotlinOrderDetailBaseDao
import com.example.demo.entity.KotlinOrderDetail
import com.example.demo.entity.dto.KotlinOrderDetailWrapper
import com.example.demo.entity.dto.Pagination
import com.github.pagehelper.PageHelper
import com.github.pagehelper.PageInfo
import com.google.common.collect.Lists
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.*

@Service
class KotlinOrderDetailFluentDaoImpl : KotlinOrderDetailBaseDao(), KotlinOrderDetailDao,
    IBaseDao<KotlinOrderDetail?> {
    override fun getType(): String {
        return JavaDaoType.FLUENT.name
    }

    @Transactional
    override fun saveData(javaSystemRole: KotlinOrderDetail) {
        this.save<Any>(javaSystemRole)
    }

    @Transactional
    override fun updateData(javaSystemRole: KotlinOrderDetail) {
        updateById(javaSystemRole)
    }

    override operator fun get(id: Long): KotlinOrderDetail? {
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

    override fun getList(wrapper: KotlinOrderDetailWrapper): List<KotlinOrderDetail>? {
        return listEntity(query())
    }

    override fun getList(
        wrapper: KotlinOrderDetailWrapper,
        page: Int,
        size: Int
    ): List<KotlinOrderDetail>? {
        PageHelper.startPage<Any>(page, size)
        return getList(wrapper)
    }

    override fun getPage(
        wrapper: KotlinOrderDetailWrapper,
        page: Int,
        size: Int
    ): Pagination<KotlinOrderDetail>? {
        PageHelper.startPage<Any>(page, size)
        return Pagination(PageInfo(getList(wrapper)))
    }
}