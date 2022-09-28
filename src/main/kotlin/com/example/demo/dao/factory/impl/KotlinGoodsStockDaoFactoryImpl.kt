package com.example.demo.dao.factory.impl

import cn.hutool.core.util.ObjUtil
import com.example.demo.constants.JavaDaoType
import com.example.demo.dao.api.KotlinGoodsStockDao
import com.example.demo.dao.factory.KotlinGoodsStockDaoFactory
import com.example.demo.entity.KotlinGoodsStock
import com.example.demo.entity.dto.KotlinGoodsStockWrapper
import com.example.demo.entity.dto.Pagination
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.function.Function
import java.util.stream.Collectors

@Service
class KotlinGoodsStockDaoFactoryImpl @Autowired constructor(systemUserDaoList: List<KotlinGoodsStockDao>) :
    KotlinGoodsStockDaoFactory {
    private val daoMap: Map<String, KotlinGoodsStockDao>

    init {
        daoMap = systemUserDaoList.stream().collect(
            Collectors.toMap(
                { obj: KotlinGoodsStockDao -> obj.getType() }, Function.identity()
            )
        )
    }

    @Transactional
    override fun saveData(type: String, data: KotlinGoodsStock) {
        getKotlinGoodsStockDao(type)?.saveData(data)
    }

    @Transactional
    override fun updateData(type: String, data: KotlinGoodsStock) {
        getKotlinGoodsStockDao(type)?.updateData(data)
    }

    override fun get(type: String, id: Long): KotlinGoodsStock? {
        return getKotlinGoodsStockDao(type)?.get(id)
    }

    @Transactional
    override fun deleteData(type: String, ids: Array<Long>) {
        getKotlinGoodsStockDao(type)?.deleteData(ids)
    }

    @Transactional
    override fun deleteData(type: String, ids: Collection<Long>) {
        getKotlinGoodsStockDao(type)?.deleteData(ids)
    }

    @Transactional
    override fun deleteData(type: String, id: Long, vararg ids: Long) {
        getKotlinGoodsStockDao(type)?.deleteData(com.google.common.collect.Lists.asList(id, ids.toTypedArray()))
    }

    override fun getList(type: String, wrapper: KotlinGoodsStockWrapper): List<KotlinGoodsStock>? {
        return getKotlinGoodsStockDao(type)?.getList(wrapper)
    }

    override fun getList(
        type: String,
        wrapper: KotlinGoodsStockWrapper,
        page: Int,
        size: Int,
    ): List<KotlinGoodsStock>? {
        return getKotlinGoodsStockDao(type)?.getList(wrapper, page, size)
    }

    override fun getPage(
        type: String,
        wrapper: KotlinGoodsStockWrapper,
        page: Int,
        size: Int,
    ): Pagination<KotlinGoodsStock>? {
        return getKotlinGoodsStockDao(type)?.getPage(wrapper, page, size)
    }

    private fun getKotlinGoodsStockDao(type: String): KotlinGoodsStockDao? {
        val javaSystemUserDao = daoMap[JavaDaoType.getType(type)]
        return if (ObjUtil.isNotEmpty(javaSystemUserDao)) {
            javaSystemUserDao
        } else {
            throw IllegalArgumentException(type)
        }
    }
}