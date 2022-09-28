package com.example.demo.dao.api.impl

import cn.org.atool.fluent.mybatis.base.IBaseDao
import com.example.demo.constants.JavaDaoType
import com.example.demo.dao.api.KotlinGoodsStockDao
import com.example.demo.dao.base.KotlinGoodsStockBaseDao
import com.example.demo.entity.KotlinGoodsStock
import com.example.demo.entity.dto.KotlinGoodsStockWrapper
import com.example.demo.entity.dto.Pagination
import com.github.pagehelper.PageHelper
import com.github.pagehelper.PageInfo
import com.google.common.collect.Lists
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.*

@Service
class KotlinGoodsStockFluentDaoImpl : KotlinGoodsStockBaseDao(), KotlinGoodsStockDao,
    IBaseDao<KotlinGoodsStock?> {
    override fun getType(): String {
        return JavaDaoType.FLUENT.name
    }

    @Transactional
    override fun saveData(javaSystemRole: KotlinGoodsStock) {
        this.save<Any>(javaSystemRole)
    }

    @Transactional
    override fun updateData(javaSystemRole: KotlinGoodsStock) {
        updateById(javaSystemRole)
    }

    override operator fun get(id: Long): KotlinGoodsStock? {
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

    override fun getList(wrapper: KotlinGoodsStockWrapper): List<KotlinGoodsStock>? {
        return listEntity(query())
    }

    override fun getList(
        wrapper: KotlinGoodsStockWrapper,
        page: Int,
        size: Int,
    ): List<KotlinGoodsStock>? {
        PageHelper.startPage<Any>(page, size)
        return getList(wrapper)
    }

    override fun getPage(
        wrapper: KotlinGoodsStockWrapper,
        page: Int,
        size: Int,
    ): Pagination<KotlinGoodsStock>? {
        PageHelper.startPage<Any>(page, size)
        return Pagination(PageInfo(getList(wrapper)))
    }
}