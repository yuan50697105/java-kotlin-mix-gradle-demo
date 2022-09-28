package com.example.demo.dao.api.impl

import com.baomidou.mybatisplus.extension.service.IService
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl
import com.example.demo.constants.JavaDaoType
import com.example.demo.dao.api.KotlinSystemDepartmentDao
import com.example.demo.entity.KotlinSystemDepartment
import com.example.demo.entity.dto.KotlinSystemDepartmentWrapper
import com.example.demo.entity.dto.Pagination
import com.example.demo.mapper.KotlinSystemDepartmentDaoMapper
import com.github.pagehelper.PageHelper
import com.github.pagehelper.PageInfo
import com.google.common.collect.Lists
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class KotlinSystemDepartmentPlusDaoImpl : ServiceImpl<KotlinSystemDepartmentDaoMapper, KotlinSystemDepartment>(),
    KotlinSystemDepartmentDao, IService<KotlinSystemDepartment> {
    override fun getType(): String {
        return JavaDaoType.PLUS.name
    }

    @Transactional
    override fun saveData(javaSystemRole: KotlinSystemDepartment) {
        save(javaSystemRole)
    }

    @Transactional
    override fun updateData(javaSystemRole: KotlinSystemDepartment) {
        this.updateById(javaSystemRole)
    }

    override operator fun get(id: Long): KotlinSystemDepartment {
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

    override fun getList(wrapper: KotlinSystemDepartmentWrapper): List<KotlinSystemDepartment> {
        return lambdaQuery().list()
    }

    override fun getList(
        wrapper: KotlinSystemDepartmentWrapper,
        page: Int,
        size: Int
    ): List<KotlinSystemDepartment> {
        PageHelper.startPage<Any>(page, size)
        return getList(wrapper)
    }

    override fun getPage(
        wrapper: KotlinSystemDepartmentWrapper,
        page: Int,
        size: Int
    ): Pagination<KotlinSystemDepartment> {
        PageHelper.startPage<Any>(page, size)
        return Pagination(PageInfo(getList(wrapper)))
    }
}