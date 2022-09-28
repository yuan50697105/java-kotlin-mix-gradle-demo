package com.example.demo.dao.factory.impl

import cn.hutool.core.util.ObjUtil
import com.example.demo.constants.JavaDaoType
import com.example.demo.dao.api.KotlinOrderDetailDao
import com.example.demo.dao.factory.KotlinOrderDetailDaoFactory
import com.example.demo.entity.KotlinOrderDetail
import com.example.demo.entity.dto.KotlinOrderDetailWrapper
import com.example.demo.entity.dto.Pagination
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.function.Function
import java.util.stream.Collectors

@Service
class KotlinOrderDetailDaoFactoryImpl @Autowired constructor(systemUserDaoList: List<KotlinOrderDetailDao>) :
    KotlinOrderDetailDaoFactory {
    private val daoMap: Map<String, KotlinOrderDetailDao>

    init {
        daoMap = systemUserDaoList.stream().collect(
            Collectors.toMap(
                { obj: KotlinOrderDetailDao -> obj.getType() }, Function.identity()
            )
        )
    }

    @Transactional
    override fun saveData(type: String, data: KotlinOrderDetail) {
        getKotlinOrderDetailDao(type)?.saveData(data)
    }

    @Transactional
    override fun updateData(type: String, data: KotlinOrderDetail) {
        getKotlinOrderDetailDao(type)?.updateData(data)
    }

    override fun get(type: String, id: Long): KotlinOrderDetail? {
        return getKotlinOrderDetailDao(type)?.get(id)
    }

    @Transactional
    override fun deleteData(type: String, ids: Array<Long>) {
        getKotlinOrderDetailDao(type)?.deleteData(ids)
    }

    @Transactional
    override fun deleteData(type: String, ids: Collection<Long>) {
        getKotlinOrderDetailDao(type)?.deleteData(ids)
    }

    @Transactional
    override fun deleteData(type: String, id: Long, vararg ids: Long) {
        getKotlinOrderDetailDao(type)?.deleteData(com.google.common.collect.Lists.asList(id, ids.toTypedArray()))
    }

    override fun getList(type: String, wrapper: KotlinOrderDetailWrapper): List<KotlinOrderDetail>? {
        return getKotlinOrderDetailDao(type)?.getList(wrapper)
    }

    override fun getList(
        type: String,
        wrapper: KotlinOrderDetailWrapper,
        page: Int,
        size: Int
    ): List<KotlinOrderDetail>? {
        return getKotlinOrderDetailDao(type)?.getList(wrapper, page, size)
    }

    override fun getPage(
        type: String,
        wrapper: KotlinOrderDetailWrapper,
        page: Int,
        size: Int
    ): Pagination<KotlinOrderDetail>? {
        return getKotlinOrderDetailDao(type)?.getPage(wrapper, page, size)
    }

    private fun getKotlinOrderDetailDao(type: String): KotlinOrderDetailDao? {
        val javaSystemUserDao = daoMap[JavaDaoType.getType(type)]
        return if (ObjUtil.isNotEmpty(javaSystemUserDao)) {
            javaSystemUserDao
        } else {
            throw IllegalArgumentException(type)
        }
    }
}