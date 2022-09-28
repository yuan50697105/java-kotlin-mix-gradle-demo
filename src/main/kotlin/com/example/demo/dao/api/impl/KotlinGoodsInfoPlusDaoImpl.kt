package com.example.demo.dao.api.impl

import com.baomidou.mybatisplus.extension.service.IService
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl
import com.example.demo.constants.JavaDaoType
import com.example.demo.dao.api.KotlinGoodsInfoDao
import com.example.demo.entity.KotlinGoodsInfo
import com.example.demo.entity.dto.KotlinGoodsInfoWrapper
import com.example.demo.entity.dto.Pagination
import com.example.demo.mapper.KotlinGoodsInfoDaoMapper
import com.github.pagehelper.PageHelper
import com.github.pagehelper.PageInfo
import com.google.common.collect.Lists
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class KotlinGoodsInfoPlusDaoImpl : ServiceImpl<KotlinGoodsInfoDaoMapper, KotlinGoodsInfo>(),
    KotlinGoodsInfoDao, IService<KotlinGoodsInfo> {
    override fun getType(): String {
        return JavaDaoType.PLUS.name
    }

    @Transactional
    override fun saveData(javaSystemRole: KotlinGoodsInfo) {
        save(javaSystemRole)
    }

    @Transactional
    override fun updateData(javaSystemRole: KotlinGoodsInfo) {
        this.updateById(javaSystemRole)
    }

    override operator fun get(id: Long): KotlinGoodsInfo {
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

    override fun getList(wrapper: KotlinGoodsInfoWrapper): List<KotlinGoodsInfo> {
        return lambdaQuery().list()
    }

    override fun getList(
        wrapper: KotlinGoodsInfoWrapper,
        page: Int,
        size: Int
    ): List<KotlinGoodsInfo> {
        PageHelper.startPage<Any>(page, size)
        return getList(wrapper)
    }

    override fun getPage(
        wrapper: KotlinGoodsInfoWrapper,
        page: Int,
        size: Int
    ): Pagination<KotlinGoodsInfo> {
        PageHelper.startPage<Any>(page, size)
        return Pagination(PageInfo(getList(wrapper)))
    }
}