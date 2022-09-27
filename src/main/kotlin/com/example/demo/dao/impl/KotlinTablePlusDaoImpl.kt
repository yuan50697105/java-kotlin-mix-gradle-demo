package com.example.demo.dao.impl

import com.baomidou.mybatisplus.extension.plugins.pagination.PageDTO
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl
import com.example.demo.constants.KotlinDaoType
import com.example.demo.dao.KotlinTableDao
import com.example.demo.entity.KotlinTable
import com.example.demo.entity.dto.KotlinTableWrapper
import com.example.demo.entity.dto.Pagination
import com.example.demo.mapper.KotlinTableDaoMapper
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class KotlinTablePlusDaoImpl : ServiceImpl<KotlinTableDaoMapper, KotlinTable>(), KotlinTableDao {
    override fun getType(): String {
        return KotlinDaoType.PLUS.name
    }

    @Transactional
    override fun updateData(kotlinTable: KotlinTable) {
        this.updateById(kotlinTable)
    }

    override fun get(id: Long): KotlinTable {
        return getById(id)
    }

    override fun getList(wrapper: KotlinTableWrapper): List<KotlinTable> {
        return ktQuery().list()
    }

    @Transactional
    override fun deleteData(id: Array<Long>) {
        this.removeByIds(id.asList())
    }

    override fun getPage(wrapper: KotlinTableWrapper, page: Int, size: Int): Pagination<KotlinTable> {
        return Pagination(ktQuery().page(PageDTO(page.toLong(), size.toLong())))
    }

    @Transactional
    override fun saveData(kotlinTable: KotlinTable) {
        this.save(kotlinTable)
    }
}