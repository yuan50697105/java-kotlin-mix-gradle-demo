package com.example.demo.service.impl

import com.example.demo.converter.KotlinGoodsStockConverter
import com.example.demo.dao.factory.KotlinGoodsStockDaoFactory
import com.example.demo.entity.KotlinGoodsStock
import com.example.demo.entity.dto.KotlinGoodsStockAddDTO
import com.example.demo.entity.dto.KotlinGoodsStockUpdateDTO
import com.example.demo.entity.dto.KotlinGoodsStockWrapper
import com.example.demo.entity.dto.Pagination
import com.example.demo.service.KotlinGoodsStockService
import org.springframework.stereotype.Service

@Service
class KotlinGoodsStockServiceImpl(
    private val daoFactory: KotlinGoodsStockDaoFactory,
    private val converter: KotlinGoodsStockConverter,
) : KotlinGoodsStockService {


    override fun saveData(type: String, table: KotlinGoodsStockAddDTO) {
        val KotlinSystemUser: KotlinGoodsStock = converter.convertForAdd(table)
        daoFactory.saveData(type, KotlinSystemUser)
    }

    override fun updateData(type: String, table: KotlinGoodsStockUpdateDTO) {
        val KotlinSystemUser: KotlinGoodsStock = converter.convertForUpdate(table)
        daoFactory.updateData(type, KotlinSystemUser)
    }

    override fun deleteData(type: String, id: Array<Long>) {
        daoFactory.deleteData(type, id)
    }

    override operator fun get(type: String, id: Long): KotlinGoodsStock? {
        return daoFactory.get(type, id)
    }

    override fun getList(type: String, wrapper: KotlinGoodsStockWrapper): List<KotlinGoodsStock>? {
        return daoFactory.getList(type, wrapper)
    }

    override fun getPage(
        type: String,
        wrapper: KotlinGoodsStockWrapper,
        page: Int,
        size: Int,
    ): Pagination<KotlinGoodsStock>? {
        return daoFactory.getPage(type, wrapper, page, size)
    }
}