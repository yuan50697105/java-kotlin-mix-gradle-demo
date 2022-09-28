package com.example.demo.dao.factory.impl

import cn.hutool.core.util.ObjUtil
import com.example.demo.constants.JavaDaoType
import com.example.demo.dao.api.KotlinOrderInfoDao
import com.example.demo.dao.factory.KotlinOrderInfoDaoFactory
import com.example.demo.entity.KotlinOrderInfo
import com.example.demo.entity.dto.KotlinOrderInfoWrapper
import com.example.demo.entity.dto.Pagination
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.function.Function
import java.util.stream.Collectors

@Service
class KotlinOrderInfoDaoFactoryImpl @Autowired constructor(systemUserDaoList: List<KotlinOrderInfoDao>) :
    KotlinOrderInfoDaoFactory {
    private val daoMap: Map<String, KotlinOrderInfoDao>

    init {
        daoMap = systemUserDaoList.stream().collect(
            Collectors.toMap(
                { obj: KotlinOrderInfoDao -> obj.getType() }, Function.identity()
            )
        )
    }

    @Transactional
    override fun saveData(type: String, data: KotlinOrderInfo) {
        getKotlinOrderInfoDao(type)?.saveData(data)
    }

    @Transactional
    override fun updateData(type: String, data: KotlinOrderInfo) {
        getKotlinOrderInfoDao(type)?.updateData(data)
    }

    override fun get(type: String, id: Long): KotlinOrderInfo? {
        return getKotlinOrderInfoDao(type)?.get(id)
    }

    @Transactional
    override fun deleteData(type: String, ids: Array<Long>) {
        getKotlinOrderInfoDao(type)?.deleteData(ids)
    }

    @Transactional
    override fun deleteData(type: String, ids: Collection<Long>) {
        getKotlinOrderInfoDao(type)?.deleteData(ids)
    }

    @Transactional
    override fun deleteData(type: String, id: Long, vararg ids: Long) {
        getKotlinOrderInfoDao(type)?.deleteData(com.google.common.collect.Lists.asList(id, ids.toTypedArray()))
    }

    override fun getList(type: String, wrapper: KotlinOrderInfoWrapper): List<KotlinOrderInfo>? {
        return getKotlinOrderInfoDao(type)?.getList(wrapper)
    }

    override fun getList(
        type: String,
        wrapper: KotlinOrderInfoWrapper,
        page: Int,
        size: Int
    ): List<KotlinOrderInfo>? {
        return getKotlinOrderInfoDao(type)?.getList(wrapper, page, size)
    }

    override fun getPage(
        type: String,
        wrapper: KotlinOrderInfoWrapper,
        page: Int,
        size: Int
    ): Pagination<KotlinOrderInfo>? {
        return getKotlinOrderInfoDao(type)?.getPage(wrapper, page, size)
    }

    private fun getKotlinOrderInfoDao(type: String): KotlinOrderInfoDao? {
        val javaSystemUserDao = daoMap[JavaDaoType.getType(type)]
        return if (ObjUtil.isNotEmpty(javaSystemUserDao)) {
            javaSystemUserDao
        } else {
            throw IllegalArgumentException(type)
        }
    }
}