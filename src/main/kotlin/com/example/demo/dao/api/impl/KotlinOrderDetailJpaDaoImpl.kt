package com.example.demo.dao.api.impl

import com.example.demo.constants.JavaDaoType
import com.example.demo.dao.api.KotlinOrderDetailDao
import com.example.demo.entity.KotlinOrderDetail
import com.example.demo.entity.dto.KotlinOrderDetailWrapper
import com.example.demo.entity.dto.Pagination
import com.example.demo.repository.KotlinOrderDetailRepository
import com.google.common.collect.Lists
import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class KotlinOrderDetailJpaDaoImpl(private val repository: KotlinOrderDetailRepository) :
    KotlinOrderDetailDao {
    override fun getType(): String {
        return JavaDaoType.JPA.name
    }

    @Transactional
    override fun saveData(javaSystemRole: KotlinOrderDetail) {
        repository.save(javaSystemRole)
    }

    override fun updateData(javaSystemRole: KotlinOrderDetail) {
        repository.save(javaSystemRole)
    }

    override fun get(id: Long): KotlinOrderDetail {
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

    override fun getList(wrapper: KotlinOrderDetailWrapper): List<KotlinOrderDetail>? {
        return repository.findAll()
    }

    override fun getList(
        wrapper: KotlinOrderDetailWrapper,
        page: Int,
        size: Int
    ): List<KotlinOrderDetail>? {
        val departments = repository.findAll(PageRequest.of(if (page <= 1) 0 else page - 1, size))
        return departments.map { it }.toList()
    }

    override fun getPage(
        wrapper: KotlinOrderDetailWrapper,
        page: Int,
        size: Int
    ): Pagination<KotlinOrderDetail>? {
        return Pagination(repository.findAll(PageRequest.of(if (page <= 1) 0 else page - 1, size)))
    }
}