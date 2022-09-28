package com.example.demo.dao.api.impl

import cn.org.atool.fluent.mybatis.base.IBaseDao
import com.example.demo.constants.JavaDaoType
import com.example.demo.dao.api.KotlinGoodsInfoDao
import com.example.demo.dao.base.KotlinGoodsInfoBaseDao
import com.example.demo.entity.KotlinGoodsInfo
import com.example.demo.entity.dto.KotlinGoodsInfoWrapper
import com.example.demo.entity.dto.Pagination
import com.github.pagehelper.PageHelper
import com.github.pagehelper.PageInfo
import com.google.common.collect.Lists
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.*

@Service
class KotlinGoodsInfoFluentDaoImpl : KotlinGoodsInfoBaseDao(), KotlinGoodsInfoDao,
    IBaseDao<KotlinGoodsInfo?> {
    override fun getType(): String {
        return JavaDaoType.FLUENT.name
    }

    @Transactional
    override fun saveData(javaSystemRole: KotlinGoodsInfo) {
        this.save<Any>(javaSystemRole)
    }

    @Transactional
    override fun updateData(javaSystemRole: KotlinGoodsInfo) {
        updateById(javaSystemRole)
    }

    override operator fun get(id: Long): KotlinGoodsInfo? {
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

    override fun getList(wrapper: KotlinGoodsInfoWrapper): List<KotlinGoodsInfo>? {
        return listEntity(query())
    }

    override fun getList(
        wrapper: KotlinGoodsInfoWrapper,
        page: Int,
        size: Int
    ): List<KotlinGoodsInfo>? {
        PageHelper.startPage<Any>(page, size)
        return getList(wrapper)
    }

    override fun getPage(
        wrapper: KotlinGoodsInfoWrapper,
        page: Int,
        size: Int
    ): Pagination<KotlinGoodsInfo>? {
        PageHelper.startPage<Any>(page, size)
        return Pagination(PageInfo(getList(wrapper)))
    }
}