package com.example.demo.service.impl

import com.example.demo.converter.KotlinSystemUserConverter
import com.example.demo.dao.factory.KotlinSystemUserDaoFactory
import com.example.demo.dao.factory.KotlinSystemUserDepartmentDaoFactory
import com.example.demo.dao.factory.KotlinSystemUserRoleDaoFactory
import com.example.demo.entity.KotlinSystemUser
import com.example.demo.entity.dto.KotlinSystemUserAddDTO
import com.example.demo.entity.dto.KotlinSystemUserUpdateDTO
import com.example.demo.entity.dto.KotlinSystemUserWrapper
import com.example.demo.entity.dto.Pagination
import com.example.demo.service.KotlinSystemUserService
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class KotlinSystemUserServiceImpl(
    private val kotlinSystemUserDaoFactory: KotlinSystemUserDaoFactory,
    private val kotlinSystemUserRoleDaoFactory: KotlinSystemUserRoleDaoFactory,
    private val kotlinSystemUserDepartmentDaoFactory: KotlinSystemUserDepartmentDaoFactory,
    private val kotlinTableConverter: KotlinSystemUserConverter
) :
    KotlinSystemUserService {
    override fun saveData(kotlinTable: KotlinSystemUserAddDTO, type: String) {
        val table = kotlinTableConverter.convertForAdd(kotlinTable)
        kotlinSystemUserDaoFactory.saveData(table, type)
        kotlinSystemUserRoleDaoFactory.saveData(type, table.id, kotlinTable.roleIds)
        kotlinSystemUserDepartmentDaoFactory.saveData(type, table.id, kotlinTable.departIds)
    }

    @Transactional
    override fun updateData(table: KotlinSystemUserUpdateDTO, type: String) {
        val kotlinTable = kotlinTableConverter.convertForUpdate(table)
        kotlinSystemUserDaoFactory.updateData(kotlinTable, type)
        kotlinSystemUserRoleDaoFactory.updateData(type, kotlinTable.id, table.roleIds)
        kotlinSystemUserDepartmentDaoFactory.updateData(type, kotlinTable.id, table.departIds)
    }

    override fun get(id: Long, type: String): KotlinSystemUser? {
        return kotlinSystemUserDaoFactory.get(id, type)
    }

    override fun getList(wrapper: KotlinSystemUserWrapper, type: String): List<KotlinSystemUser>? {
        return kotlinSystemUserDaoFactory.getList(wrapper, type)
    }

    override fun getPage(
        wrapper: KotlinSystemUserWrapper,
        page: Int,
        size: Int,
        type: String
    ): Pagination<KotlinSystemUser>? {
        return kotlinSystemUserDaoFactory.getPage(wrapper, page, size, type)
    }

    @Transactional
    override fun deleteData(id: Array<Long>, type: String) {
        kotlinSystemUserDaoFactory.deleteData(id, type)
        kotlinSystemUserRoleDaoFactory.deleteDataByUserIds(type, id)
        kotlinSystemUserDepartmentDaoFactory.deleteDataByUserIds(type, id)
    }
}