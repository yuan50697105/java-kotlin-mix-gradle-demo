package com.example.demo.service.impl

import com.example.demo.converter.KotlinCustomerInfoConverter
import com.example.demo.dao.factory.KotlinCustomerInfoDaoFactory
import com.example.demo.entity.KotlinCustomerInfo
import com.example.demo.entity.dto.KotlinCustomerInfoAddDTO
import com.example.demo.entity.dto.KotlinCustomerInfoUpdateDTO
import com.example.demo.entity.dto.KotlinCustomerInfoWrapper
import com.example.demo.entity.dto.Pagination
import com.example.demo.service.KotlinCustomerInfoService
import org.springframework.stereotype.Service

@Service
class KotlinCustomerInfoServiceImpl(
    private val daoFactory: KotlinCustomerInfoDaoFactory,
    private val converter: KotlinCustomerInfoConverter
) : KotlinCustomerInfoService {


    override fun saveData(type: String, table: KotlinCustomerInfoAddDTO) {
        val KotlinSystemUser: KotlinCustomerInfo = converter.convertForAdd(table)
        daoFactory.saveData(type, KotlinSystemUser)
    }

    override fun updateData(type: String, table: KotlinCustomerInfoUpdateDTO) {
        val KotlinSystemUser: KotlinCustomerInfo = converter.convertForUpdate(table)
        daoFactory.updateData(type, KotlinSystemUser)
    }

    override fun deleteData(type: String, id: Array<Long>) {
        daoFactory.deleteData(type, id)
    }

    override operator fun get(type: String, id: Long): KotlinCustomerInfo? {
        return daoFactory.get(type, id)
    }

    override fun getList(type: String, wrapper: KotlinCustomerInfoWrapper): List<KotlinCustomerInfo>? {
        return daoFactory.getList(type, wrapper)
    }

    override fun getPage(
        type: String,
        wrapper: KotlinCustomerInfoWrapper,
        page: Int,
        size: Int
    ): Pagination<KotlinCustomerInfo>? {
        return daoFactory.getPage(type, wrapper, page, size)
    }
}