package com.example.demo.dao.api.impl

import com.baomidou.mybatisplus.extension.service.IService
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl
import com.example.demo.constants.JavaDaoType
import com.example.demo.dao.api.KotlinGoodsStockDao
import com.example.demo.entity.KotlinGoodsStock
import com.example.demo.entity.dto.KotlinGoodsStockWrapper
import com.example.demo.entity.dto.Pagination
import com.example.demo.mapper.KotlinGoodsStockDaoMapper
import com.github.pagehelper.PageHelper
import com.github.pagehelper.PageInfo
import com.google.common.collect.Lists
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class KotlinGoodsStockPlusDaoImpl : ServiceImpl<KotlinGoodsStockDaoMapper, KotlinGoodsStock>(),
    KotlinGoodsStockDao, IService<KotlinGoodsStock> {
    override fun getType(): String {
        return JavaDaoType.PLUS.name
    }

    @Transactional
    override fun saveData(javaSystemRole: KotlinGoodsStock) {
        save(javaSystemRole)
    }

    @Transactional
    override fun updateData(javaSystemRole: KotlinGoodsStock) {
        this.updateById(javaSystemRole)
    }

    override operator fun get(id: Long): KotlinGoodsStock {
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

    override fun getList(wrapper: KotlinGoodsStockWrapper): List<KotlinGoodsStock> {
        return lambdaQuery().list()
    }

    override fun getList(
        wrapper: KotlinGoodsStockWrapper,
        page: Int,
        size: Int,
    ): List<KotlinGoodsStock> {
        PageHelper.startPage<Any>(page, size)
        return getList(wrapper)
    }

    override fun getPage(
        wrapper: KotlinGoodsStockWrapper,
        page: Int,
        size: Int,
    ): Pagination<KotlinGoodsStock> {
        PageHelper.startPage<Any>(page, size)
        return Pagination(PageInfo(getList(wrapper)))
    }
}