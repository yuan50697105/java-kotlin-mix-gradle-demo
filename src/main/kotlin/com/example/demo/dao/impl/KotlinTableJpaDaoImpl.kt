package com.example.demo.dao.impl

import com.example.demo.dao.KotlinTableDao
import com.example.demo.entity.KotlinTable
import com.example.demo.entity.dto.KotlinTableWrapper
import com.example.demo.entity.dto.Pagination
import com.example.demo.repository.KotlinTableRepository
import com.example.demo.service.KotlinTableDaoFactory
import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Service
import java.util.Arrays
import javax.transaction.Transactional

@Service
class KotlinTableJpaDaoImpl(private val kotlinTableRepository: KotlinTableRepository) : KotlinTableDao {
    override fun getType(): String {
        return KotlinTableDaoFactory.DaoType.JPA.name
    }

    @Transactional
    override fun updateData(kotlinTable: KotlinTable) {
        kotlinTableRepository.save(kotlinTable)
    }

    override fun get(id: Long): KotlinTable {
        return kotlinTableRepository.findById(id).orElse(null)
    }

    override fun getList(wrapper: KotlinTableWrapper): List<KotlinTable> {
        return kotlinTableRepository.findAll()
    }

    override fun getPage(wrapper: KotlinTableWrapper, page: Int, size: Int): Pagination<KotlinTable> {
        val pageIndex = if (page <= 1) 0 else page - 1
        return Pagination(kotlinTableRepository.findAll(PageRequest.of(pageIndex, size)))
    }

    override fun deleteData(id: Array<Long>) {
        kotlinTableRepository.deleteAllById(id.asList())
    }

    @Transactional
    override fun saveData(kotlinTable: KotlinTable) {
        kotlinTableRepository.save(kotlinTable)
    }
}