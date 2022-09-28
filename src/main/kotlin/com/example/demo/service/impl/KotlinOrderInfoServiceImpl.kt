package com.example.demo.service.impl

import com.example.demo.converter.KotlinOrderDetailConverter
import com.example.demo.converter.KotlinOrderInfoConverter
import com.example.demo.dao.factory.KotlinOrderDetailDaoFactory
import com.example.demo.dao.factory.KotlinOrderInfoDaoFactory
import com.example.demo.entity.KotlinOrderInfo
import com.example.demo.entity.dto.KotlinOrderInfoAddDTO
import com.example.demo.entity.dto.KotlinOrderInfoUpdateDTO
import com.example.demo.entity.dto.KotlinOrderInfoWrapper
import com.example.demo.entity.dto.Pagination
import com.example.demo.service.KotlinOrderInfoService
import org.springframework.stereotype.Service

@Service
class KotlinOrderInfoServiceImpl(
    private val orderInfoDaoFactory: KotlinOrderInfoDaoFactory,
    private val orderDetailDaoFactory: KotlinOrderDetailDaoFactory,
    private val orderInfoConverter: KotlinOrderInfoConverter,
    private val orderDetailConverter: KotlinOrderDetailConverter
) : KotlinOrderInfoService {


    override fun saveData(type: String, table: KotlinOrderInfoAddDTO) {
        val KotlinSystemUser: KotlinOrderInfo = orderInfoConverter.convertForAdd(table)
        orderInfoDaoFactory.saveData(type, KotlinSystemUser)
    }

    override fun updateData(type: String, table: KotlinOrderInfoUpdateDTO) {
        val KotlinSystemUser: KotlinOrderInfo = orderInfoConverter.convertForUpdate(table)
        orderInfoDaoFactory.updateData(type, KotlinSystemUser)
    }

    override fun deleteData(type: String, id: Array<Long>) {
        orderInfoDaoFactory.deleteData(type, id)
    }

    override operator fun get(type: String, id: Long): KotlinOrderInfo? {
        return orderInfoDaoFactory.get(type, id)
    }

    override fun getList(type: String, wrapper: KotlinOrderInfoWrapper): List<KotlinOrderInfo>? {
        return orderInfoDaoFactory.getList(type, wrapper)
    }

    override fun getPage(
        type: String,
        wrapper: KotlinOrderInfoWrapper,
        page: Int,
        size: Int
    ): Pagination<KotlinOrderInfo>? {
        return orderInfoDaoFactory.getPage(type, wrapper, page, size)
    }
}