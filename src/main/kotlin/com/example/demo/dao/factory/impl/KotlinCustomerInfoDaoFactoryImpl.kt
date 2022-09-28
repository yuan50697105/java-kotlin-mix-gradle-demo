package com.example.demo.dao.factory.impl

import cn.hutool.core.util.ObjUtil
import com.example.demo.constants.JavaDaoType
import com.example.demo.dao.api.KotlinCustomerInfoDao
import com.example.demo.dao.factory.KotlinCustomerInfoDaoFactory
import com.example.demo.entity.KotlinCustomerInfo
import com.example.demo.entity.dto.KotlinCustomerInfoWrapper
import com.example.demo.entity.dto.Pagination
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.function.Function
import java.util.stream.Collectors

@Service
class KotlinCustomerInfoDaoFactoryImpl @Autowired constructor(systemUserDaoList: List<KotlinCustomerInfoDao>) :
    KotlinCustomerInfoDaoFactory {
    private val daoMap: Map<String, KotlinCustomerInfoDao>

    init {
        daoMap = systemUserDaoList.stream().collect(
            Collectors.toMap(
                { obj: KotlinCustomerInfoDao -> obj.getType() }, Function.identity()
            )
        )
    }

    @Transactional
    override fun saveData(type: String, data: KotlinCustomerInfo) {
        getKotlinCustomerInfoDao(type)?.saveData(data)
    }

    @Transactional
    override fun updateData(type: String, data: KotlinCustomerInfo) {
        getKotlinCustomerInfoDao(type)?.updateData(data)
    }

    override fun get(type: String, id: Long): KotlinCustomerInfo? {
        return getKotlinCustomerInfoDao(type)?.get(id)
    }

    @Transactional
    override fun deleteData(type: String, ids: Array<Long>) {
        getKotlinCustomerInfoDao(type)?.deleteData(ids)
    }

    @Transactional
    override fun deleteData(type: String, ids: Collection<Long>) {
        getKotlinCustomerInfoDao(type)?.deleteData(ids)
    }

    @Transactional
    override fun deleteData(type: String, id: Long, vararg ids: Long) {
        getKotlinCustomerInfoDao(type)?.deleteData(com.google.common.collect.Lists.asList(id, ids.toTypedArray()))
    }

    override fun getList(type: String, wrapper: KotlinCustomerInfoWrapper): List<KotlinCustomerInfo>? {
        return getKotlinCustomerInfoDao(type)?.getList(wrapper)
    }

    override fun getList(
        type: String,
        wrapper: KotlinCustomerInfoWrapper,
        page: Int,
        size: Int
    ): List<KotlinCustomerInfo>? {
        return getKotlinCustomerInfoDao(type)?.getList(wrapper, page, size)
    }

    override fun getPage(
        type: String,
        wrapper: KotlinCustomerInfoWrapper,
        page: Int,
        size: Int
    ): Pagination<KotlinCustomerInfo>? {
        return getKotlinCustomerInfoDao(type)?.getPage(wrapper, page, size)
    }

    private fun getKotlinCustomerInfoDao(type: String): KotlinCustomerInfoDao? {
        val javaSystemUserDao = daoMap[JavaDaoType.getType(type)]
        return if (ObjUtil.isNotEmpty(javaSystemUserDao)) {
            javaSystemUserDao
        } else {
            throw IllegalArgumentException(type)
        }
    }
}