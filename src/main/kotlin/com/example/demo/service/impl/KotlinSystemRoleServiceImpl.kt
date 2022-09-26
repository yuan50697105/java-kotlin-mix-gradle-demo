package com.example.demo.service.impl

import com.example.demo.converter.KotlinSystemRoleConverter
import com.example.demo.dao.factory.KotlinSystemRoleDaoFactory
import com.example.demo.entity.KotlinSystemRole
import com.example.demo.entity.dto.KotlinSystemRoleAddDTO
import com.example.demo.entity.dto.KotlinSystemRoleUpdateDTO
import com.example.demo.entity.dto.KotlinSystemRoleWrapper
import com.example.demo.entity.dto.Pagination
import com.example.demo.service.KotlinSystemRoleService
import org.springframework.stereotype.Service

@Service
class KotlinSystemRoleServiceImpl(
    private val kotlinTableDaoFactory: KotlinSystemRoleDaoFactory,
    private val kotlinTableConverter: KotlinSystemRoleConverter
) :
    KotlinSystemRoleService {
    override fun saveData(kotlinTable: KotlinSystemRoleAddDTO, type: String) {
        val table = kotlinTableConverter.convertForAdd(kotlinTable)
        kotlinTableDaoFactory.saveData(table, type)
    }

    override fun updateData(table: KotlinSystemRoleUpdateDTO, type: String) {
        val kotlinTable = kotlinTableConverter.convertForUpdate(table)
        kotlinTableDaoFactory.updateData(kotlinTable, type)

    }

    override fun get(id: Long, type: String): KotlinSystemRole? {
        return kotlinTableDaoFactory.get(id, type)
    }

    override fun getList(wrapper: KotlinSystemRoleWrapper, type: String): List<KotlinSystemRole>? {
        return kotlinTableDaoFactory.getList(wrapper, type)
    }

    override fun getPage(
        wrapper: KotlinSystemRoleWrapper,
        page: Int,
        size: Int,
        type: String
    ): Pagination<KotlinSystemRole>? {
        return kotlinTableDaoFactory.getPage(wrapper, page, size, type)
    }

    override fun deleteData(id: Array<Long>, type: String) {
        kotlinTableDaoFactory.deleteData(id, type)
    }
}