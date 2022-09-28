package com.example.demo.dao.factory.impl

import cn.hutool.core.util.ObjUtil
import com.example.demo.constants.JavaDaoType
import com.example.demo.dao.api.KotlinGoodsInfoDao
import com.example.demo.dao.factory.KotlinGoodsInfoDaoFactory
import com.example.demo.entity.KotlinGoodsInfo
import com.example.demo.entity.dto.KotlinGoodsInfoWrapper
import com.example.demo.entity.dto.Pagination
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.function.Function
import java.util.stream.Collectors

@Service
class KotlinGoodsInfoDaoFactoryImpl @Autowired constructor(systemUserDaoList: List<KotlinGoodsInfoDao>) :
    KotlinGoodsInfoDaoFactory {
    private val daoMap: Map<String, KotlinGoodsInfoDao>

    init {
        daoMap = systemUserDaoList.stream().collect(
            Collectors.toMap(
                { obj: KotlinGoodsInfoDao -> obj.getType() }, Function.identity()
            )
        )
    }

    @Transactional
    override fun saveData(type: String, data: KotlinGoodsInfo) {
        getKotlinGoodsInfoDao(type)?.saveData(data)
    }

    @Transactional
    override fun updateData(type: String, data: KotlinGoodsInfo) {
        getKotlinGoodsInfoDao(type)?.updateData(data)
    }

    override fun get(type: String, id: Long): KotlinGoodsInfo? {
        return getKotlinGoodsInfoDao(type)?.get(id)
    }

    @Transactional
    override fun deleteData(type: String, ids: Array<Long>) {
        getKotlinGoodsInfoDao(type)?.deleteData(ids)
    }

    @Transactional
    override fun deleteData(type: String, ids: Collection<Long>) {
        getKotlinGoodsInfoDao(type)?.deleteData(ids)
    }

    @Transactional
    override fun deleteData(type: String, id: Long, vararg ids: Long) {
        getKotlinGoodsInfoDao(type)?.deleteData(com.google.common.collect.Lists.asList(id, ids.toTypedArray()))
    }

    override fun getList(type: String, wrapper: KotlinGoodsInfoWrapper): List<KotlinGoodsInfo>? {
        return getKotlinGoodsInfoDao(type)?.getList(wrapper)
    }

    override fun getList(
        type: String,
        wrapper: KotlinGoodsInfoWrapper,
        page: Int,
        size: Int
    ): List<KotlinGoodsInfo>? {
        return getKotlinGoodsInfoDao(type)?.getList(wrapper, page, size)
    }

    override fun getPage(
        type: String,
        wrapper: KotlinGoodsInfoWrapper,
        page: Int,
        size: Int
    ): Pagination<KotlinGoodsInfo>? {
        return getKotlinGoodsInfoDao(type)?.getPage(wrapper, page, size)
    }

    private fun getKotlinGoodsInfoDao(type: String): KotlinGoodsInfoDao? {
        val javaSystemUserDao = daoMap[JavaDaoType.getType(type)]
        return if (ObjUtil.isNotEmpty(javaSystemUserDao)) {
            javaSystemUserDao
        } else {
            throw IllegalArgumentException(type)
        }
    }
}