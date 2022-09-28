package com.example.demo.dao.api.impl

import com.example.demo.constants.JavaDaoType
import com.example.demo.dao.api.KotlinGoodsStockDao
import com.example.demo.entity.KotlinGoodsStock
import com.example.demo.entity.dto.KotlinGoodsStockWrapper
import com.example.demo.entity.dto.Pagination
import com.example.demo.repository.KotlinGoodsStockRepository
import com.google.common.collect.Lists
import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class KotlinGoodsStockJpaDaoImpl(private val repository: KotlinGoodsStockRepository) :
    KotlinGoodsStockDao {
    override fun getType(): String {
        return JavaDaoType.JPA.name
    }

    @Transactional
    override fun saveData(javaSystemRole: KotlinGoodsStock) {
        repository.save(javaSystemRole)
    }

    override fun updateData(javaSystemRole: KotlinGoodsStock) {
        repository.save(javaSystemRole)
    }

    override fun get(id: Long): KotlinGoodsStock {
        return repository.findById(id).orElse(null)
    }

    @Transactional
    override fun deleteData(ids: Array<Long>) {
        this.deleteData(listOf(*ids))
    }

    @Transactional
    override fun deleteData(ids: Collection<Long>) {
        repository.deleteAllById(ids)
    }

    override fun deleteData(id: Long, vararg ids: Long) {
        this.deleteData(Lists.asList(id, ids.toTypedArray()))
    }

    override fun getList(wrapper: KotlinGoodsStockWrapper): List<KotlinGoodsStock>? {
        return repository.findAll()
    }

    override fun getList(
        wrapper: KotlinGoodsStockWrapper,
        page: Int,
        size: Int,
    ): List<KotlinGoodsStock>? {
        val departments = repository.findAll(PageRequest.of(if (page <= 1) 0 else page - 1, size))
        return departments.map { it }.toList()
    }

    override fun getPage(
        wrapper: KotlinGoodsStockWrapper,
        page: Int,
        size: Int,
    ): Pagination<KotlinGoodsStock>? {
        return Pagination(repository.findAll(PageRequest.of(if (page <= 1) 0 else page - 1, size)))
    }
}