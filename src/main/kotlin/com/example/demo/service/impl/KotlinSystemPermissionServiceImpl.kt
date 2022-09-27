package com.example.demo.service.impl

import com.example.demo.converter.KotlinSystemPermissionConverter
import com.example.demo.dao.factory.KotlinSystemPermissionDaoFactory
import com.example.demo.dao.factory.KotlinSystemUserRoleDaoFactory
import com.example.demo.entity.KotlinSystemPermission
import com.example.demo.entity.dto.KotlinSystemPermissionAddDTO
import com.example.demo.entity.dto.KotlinSystemPermissionUpdateDTO
import com.example.demo.entity.dto.KotlinSystemPermissionWrapper
import com.example.demo.entity.dto.Pagination
import com.example.demo.service.KotlinSystemPermissionService
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class KotlinSystemPermissionServiceImpl(
    private val kotlinTableDaoFactory: KotlinSystemPermissionDaoFactory,
    private val kotlinSystemUserRoleDaoFactory: KotlinSystemUserRoleDaoFactory,
    private val kotlinTableConverter: KotlinSystemPermissionConverter
) :
    KotlinSystemPermissionService {
    override fun saveData(kotlinTable: KotlinSystemPermissionAddDTO, type: String) {
        val table = kotlinTableConverter.convertForAdd(kotlinTable)
        kotlinTableDaoFactory.saveData(table, type)
    }

    override fun updateData(table: KotlinSystemPermissionUpdateDTO, type: String) {
        val kotlinTable = kotlinTableConverter.convertForUpdate(table)
        kotlinTableDaoFactory.updateData(kotlinTable, type)

    }

    override fun get(id: Long, type: String): KotlinSystemPermission? {
        return kotlinTableDaoFactory.get(id, type)
    }

    override fun getList(wrapper: KotlinSystemPermissionWrapper, type: String): List<KotlinSystemPermission>? {
        return kotlinTableDaoFactory.getList(wrapper, type)
    }

    override fun getPage(
        wrapper: KotlinSystemPermissionWrapper,
        page: Int,
        size: Int,
        type: String
    ): Pagination<KotlinSystemPermission>? {
        return kotlinTableDaoFactory.getPage(wrapper, page, size, type)
    }

    @Transactional
    override fun deleteData(id: Array<Long>, type: String) {
        kotlinTableDaoFactory.deleteData(id, type)
        kotlinSystemUserRoleDaoFactory.deleteDataByRoleIds(type, id)

    }
}