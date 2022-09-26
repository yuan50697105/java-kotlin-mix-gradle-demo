package com.example.demo.service.impl

import com.example.demo.converter.KotlinSystemUserConverter
import com.example.demo.entity.KotlinSystemUser
import com.example.demo.entity.dto.KotlinSystemUserAddDTO
import com.example.demo.entity.dto.KotlinSystemUserUpdateDTO
import com.example.demo.entity.dto.KotlinSystemUserWrapper
import com.example.demo.entity.dto.Pagination
import com.example.demo.service.KotlinSystemUserDaoFactory
import com.example.demo.service.KotlinSystemUserService
import org.springframework.stereotype.Service

@Service
class KotlinSystemUserServiceImpl(
    private val kotlinTableDaoFactory: KotlinSystemUserDaoFactory,
    private val kotlinTableConverter: KotlinSystemUserConverter
) :
    KotlinSystemUserService {
    override fun saveData(kotlinTable: KotlinSystemUserAddDTO, type: String) {
        val table = kotlinTableConverter.convertForAdd(kotlinTable)
        kotlinTableDaoFactory.saveData(table, type)
    }

    override fun updateData(table: KotlinSystemUserUpdateDTO, type: String) {
        val kotlinTable = kotlinTableConverter.convertForUpdate(table)
        kotlinTableDaoFactory.updateData(kotlinTable, type)

    }

    override fun get(id: Long, type: String): KotlinSystemUser? {
        return kotlinTableDaoFactory.get(id, type)
    }

    override fun getList(wrapper: KotlinSystemUserWrapper, type: String): List<KotlinSystemUser>? {
        return kotlinTableDaoFactory.getList(wrapper, type)
    }

    override fun getPage(
        wrapper: KotlinSystemUserWrapper,
        page: Int,
        size: Int,
        type: String
    ): Pagination<KotlinSystemUser>? {
        return kotlinTableDaoFactory.getPage(wrapper, page, size, type)
    }

    override fun deleteData(id: Array<Long>, type: String) {
        kotlinTableDaoFactory.deleteData(id, type)
    }
}