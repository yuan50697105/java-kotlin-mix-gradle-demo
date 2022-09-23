package com.example.demo.service.impl

import com.example.demo.converter.KotlinTableConverter
import com.example.demo.entity.KotlinTable
import com.example.demo.entity.dto.KotlinTableAddDTO
import com.example.demo.entity.dto.KotlinTableUpdateDTO
import com.example.demo.entity.dto.KotlinTableWrapper
import com.example.demo.entity.dto.Pagination
import com.example.demo.service.KotlinTableDaoFactory
import com.example.demo.service.KotlinTableService
import org.springframework.stereotype.Service

@Service
class KotlinTableServiceImpl(private val kotlinTableDaoFactory: KotlinTableDaoFactory,private val kotlinTableConverter: KotlinTableConverter) : KotlinTableService {
    override fun saveData(kotlinTable: KotlinTableAddDTO, type: String) {
        val table = kotlinTableConverter.convertForAdd(kotlinTable)
        kotlinTableDaoFactory.saveData(table, type)
    }

    override fun updateData(table: KotlinTableUpdateDTO, type: String) {
        val kotlinTable = kotlinTableConverter.convertForUpdate(table)
        kotlinTableDaoFactory.updateData(kotlinTable, type)

    }

    override fun get(id: Long, type: String): KotlinTable? {
        return kotlinTableDaoFactory.get(id, type)
    }

    override fun getList(wrapper: KotlinTableWrapper, type: String): List<KotlinTable>? {
        return kotlinTableDaoFactory.getList(wrapper, type)
    }

    override fun getPage(wrapper: KotlinTableWrapper, page: Int, size: Int, type: String): Pagination<KotlinTable>? {
        return kotlinTableDaoFactory.getPage(wrapper, page, size, type)
    }

    override fun deleteData(id: Array<Long>, type: String) {
        kotlinTableDaoFactory.deleteData(id, type)
    }
}