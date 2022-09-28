package com.example.demo.dao.api.impl

import com.baomidou.mybatisplus.extension.service.IService
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl
import com.example.demo.constants.JavaDaoType
import com.example.demo.dao.api.KotlinOrderDetailDao
import com.example.demo.entity.KotlinOrderDetail
import com.example.demo.entity.dto.KotlinOrderDetailWrapper
import com.example.demo.entity.dto.Pagination
import com.example.demo.mapper.KotlinOrderDetailDaoMapper
import com.github.pagehelper.PageHelper
import com.github.pagehelper.PageInfo
import com.google.common.collect.Lists
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class KotlinOrderDetailPlusDaoImpl : ServiceImpl<KotlinOrderDetailDaoMapper, KotlinOrderDetail>(),
    KotlinOrderDetailDao, IService<KotlinOrderDetail> {
    override fun getType(): String {
        return JavaDaoType.PLUS.name
    }

    @Transactional
    override fun saveData(javaSystemRole: KotlinOrderDetail) {
        save(javaSystemRole)
    }

    @Transactional
    override fun updateData(javaSystemRole: KotlinOrderDetail) {
        this.updateById(javaSystemRole)
    }

    override operator fun get(id: Long): KotlinOrderDetail {
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

    override fun getList(wrapper: KotlinOrderDetailWrapper): List<KotlinOrderDetail> {
        return lambdaQuery().list()
    }

    override fun getList(
        wrapper: KotlinOrderDetailWrapper,
        page: Int,
        size: Int
    ): List<KotlinOrderDetail> {
        PageHelper.startPage<Any>(page, size)
        return getList(wrapper)
    }

    override fun getPage(
        wrapper: KotlinOrderDetailWrapper,
        page: Int,
        size: Int
    ): Pagination<KotlinOrderDetail> {
        PageHelper.startPage<Any>(page, size)
        return Pagination(PageInfo(getList(wrapper)))
    }
}