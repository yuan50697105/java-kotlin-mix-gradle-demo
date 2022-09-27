package com.example.demo.service.impl

import com.example.demo.converter.KotlinSystemDepartmentConverter
import com.example.demo.dao.factory.KotlinSystemDepartmentDaoFactory
import com.example.demo.dao.factory.KotlinSystemRolePermissionDaoFactory
import com.example.demo.entity.KotlinSystemDepartment
import com.example.demo.entity.dto.KotlinSystemDepartmentAddDTO
import com.example.demo.entity.dto.KotlinSystemDepartmentUpdateDTO
import com.example.demo.entity.dto.KotlinSystemDepartmentWrapper
import com.example.demo.entity.dto.Pagination
import com.example.demo.service.KotlinSystemDepartmentService
import org.springframework.stereotype.Service

@Service
class KotlinSystemDepartmentServiceImpl(
    daoFactory: KotlinSystemDepartmentDaoFactory,
    systemRolePermissionDaoFactory: KotlinSystemRolePermissionDaoFactory,
    converter: KotlinSystemDepartmentConverter
) : KotlinSystemDepartmentService {
    private val daoFactory: KotlinSystemDepartmentDaoFactory
    private val systemRolePermissionDaoFactory: KotlinSystemRolePermissionDaoFactory
    private val converter: KotlinSystemDepartmentConverter

    init {
        this.daoFactory = daoFactory
        this.systemRolePermissionDaoFactory = systemRolePermissionDaoFactory
        this.converter = converter
    }

    override fun saveData(type: String, table: KotlinSystemDepartmentAddDTO) {
        val KotlinSystemUser: KotlinSystemDepartment = converter.convertForAdd(table)
        daoFactory.saveData(type, KotlinSystemUser)
    }

    override fun updateData(type: String, table: KotlinSystemDepartmentUpdateDTO) {
        val KotlinSystemUser: KotlinSystemDepartment = converter.convertForUpdate(table)
        daoFactory.updateData(type, KotlinSystemUser)
    }

    override fun deleteData(type: String, id: Array<Long>) {
        daoFactory.deleteData(type, id)
    }

    override operator fun get(type: String, id: Long): KotlinSystemDepartment? {
        return daoFactory.get(type, id)
    }

    override fun getList(type: String, wrapper: KotlinSystemDepartmentWrapper): List<KotlinSystemDepartment>? {
        return daoFactory.getList(type, wrapper)
    }

    override fun getPage(
        type: String,
        wrapper: KotlinSystemDepartmentWrapper,
        page: Int,
        size: Int
    ): Pagination<KotlinSystemDepartment>? {
        return daoFactory.getPage(type, wrapper, page, size)
    }
}