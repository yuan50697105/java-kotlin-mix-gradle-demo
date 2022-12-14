package com.example.demo.dao.api.impl

import com.example.demo.constants.KotlinDaoType
import com.example.demo.dao.api.KotlinTableDao
import com.example.demo.dao.base.KotlinTableBaseDao
import com.example.demo.entity.KotlinTable
import com.example.demo.entity.dto.KotlinTableWrapper
import com.example.demo.entity.dto.Pagination
import com.github.pagehelper.PageHelper
import com.github.pagehelper.PageInfo
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class KotlinTableFluentDaoImpl : KotlinTableBaseDao(), KotlinTableDao {
    override fun getType(): String {
        return KotlinDaoType.FLUENT.name
    }

    @Transactional
    override fun updateData(kotlinTable: KotlinTable) {
        this.updateById(kotlinTable)
    }

    override fun get(id: Long): KotlinTable {
        return selectById(id)
    }

    override fun getPage(wrapper: KotlinTableWrapper, page: Int, size: Int): Pagination<KotlinTable> {
        PageHelper.startPage<Any>(page, size)
        return Pagination(PageInfo.of(listEntity(query())))

    }

    @Transactional
    override fun deleteData(id: Array<Long>) {
        deleteByIds(id.asList())
    }

    override fun getList(wrapper: KotlinTableWrapper): List<KotlinTable> {
        return listEntity(query())
    }

    @Transactional
    override fun saveData(kotlinTable: KotlinTable) {
        this.save<KotlinTable>(kotlinTable)
    }
}