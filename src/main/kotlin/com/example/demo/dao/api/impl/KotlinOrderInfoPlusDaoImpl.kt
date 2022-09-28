package com.example.demo.dao.api.impl

import com.baomidou.mybatisplus.extension.service.IService
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl
import com.example.demo.constants.JavaDaoType
import com.example.demo.dao.api.KotlinOrderInfoDao
import com.example.demo.entity.KotlinOrderInfo
import com.example.demo.entity.dto.KotlinOrderInfoWrapper
import com.example.demo.entity.dto.Pagination
import com.example.demo.mapper.KotlinOrderInfoDaoMapper
import com.github.pagehelper.PageHelper
import com.github.pagehelper.PageInfo
import com.google.common.collect.Lists
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class KotlinOrderInfoPlusDaoImpl : ServiceImpl<KotlinOrderInfoDaoMapper, KotlinOrderInfo>(),
    KotlinOrderInfoDao, IService<KotlinOrderInfo> {
    override fun getType(): String {
        return JavaDaoType.PLUS.name
    }

    @Transactional
    override fun saveData(javaSystemRole: KotlinOrderInfo) {
        save(javaSystemRole)
    }

    @Transactional
    override fun updateData(javaSystemRole: KotlinOrderInfo) {
        this.updateById(javaSystemRole)
    }

    override operator fun get(id: Long): KotlinOrderInfo {
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

    override fun getList(wrapper: KotlinOrderInfoWrapper): List<KotlinOrderInfo> {
        return lambdaQuery().list()
    }

    override fun getList(
        wrapper: KotlinOrderInfoWrapper,
        page: Int,
        size: Int
    ): List<KotlinOrderInfo> {
        PageHelper.startPage<Any>(page, size)
        return getList(wrapper)
    }

    override fun getPage(
        wrapper: KotlinOrderInfoWrapper,
        page: Int,
        size: Int
    ): Pagination<KotlinOrderInfo> {
        PageHelper.startPage<Any>(page, size)
        return Pagination(PageInfo(getList(wrapper)))
    }
}