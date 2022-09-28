package com.example.demo.service.impl

import com.example.demo.converter.KotlinGoodsInfoConverter
import com.example.demo.dao.factory.KotlinGoodsInfoDaoFactory
import com.example.demo.entity.KotlinGoodsInfo
import com.example.demo.entity.dto.KotlinGoodsInfoAddDTO
import com.example.demo.entity.dto.KotlinGoodsInfoUpdateDTO
import com.example.demo.entity.dto.KotlinGoodsInfoWrapper
import com.example.demo.entity.dto.Pagination
import com.example.demo.service.KotlinGoodsInfoService
import org.springframework.stereotype.Service

@Service
class KotlinGoodsInfoServiceImpl(
    private val daoFactory: KotlinGoodsInfoDaoFactory,
    private val converter: KotlinGoodsInfoConverter
) : KotlinGoodsInfoService {


    override fun saveData(type: String, table: KotlinGoodsInfoAddDTO) {
        val KotlinSystemUser: KotlinGoodsInfo = converter.convertForAdd(table)
        daoFactory.saveData(type, KotlinSystemUser)
    }

    override fun updateData(type: String, table: KotlinGoodsInfoUpdateDTO) {
        val KotlinSystemUser: KotlinGoodsInfo = converter.convertForUpdate(table)
        daoFactory.updateData(type, KotlinSystemUser)
    }

    override fun deleteData(type: String, id: Array<Long>) {
        daoFactory.deleteData(type, id)
    }

    override operator fun get(type: String, id: Long): KotlinGoodsInfo? {
        return daoFactory.get(type, id)
    }

    override fun getList(type: String, wrapper: KotlinGoodsInfoWrapper): List<KotlinGoodsInfo>? {
        return daoFactory.getList(type, wrapper)
    }

    override fun getPage(
        type: String,
        wrapper: KotlinGoodsInfoWrapper,
        page: Int,
        size: Int
    ): Pagination<KotlinGoodsInfo>? {
        return daoFactory.getPage(type, wrapper, page, size)
    }
}