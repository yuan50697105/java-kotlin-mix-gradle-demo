package com.example.demo.dao.api.impl

import com.example.demo.constants.JavaDaoType
import com.example.demo.dao.api.KotlinOrderInfoDao
import com.example.demo.entity.KotlinOrderInfo
import com.example.demo.entity.dto.KotlinOrderInfoWrapper
import com.example.demo.entity.dto.Pagination
import com.example.demo.repository.KotlinOrderInfoRepository
import com.google.common.collect.Lists
import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class KotlinOrderInfoJpaDaoImpl(private val repository: KotlinOrderInfoRepository) :
    KotlinOrderInfoDao {
    override fun getType(): String {
        return JavaDaoType.JPA.name
    }

    @Transactional
    override fun saveData(javaSystemRole: KotlinOrderInfo) {
        repository.save(javaSystemRole)
    }

    override fun updateData(javaSystemRole: KotlinOrderInfo) {
        repository.save(javaSystemRole)
    }

    override fun get(id: Long): KotlinOrderInfo {
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

    override fun getList(wrapper: KotlinOrderInfoWrapper): List<KotlinOrderInfo>? {
        return repository.findAll()
    }

    override fun getList(
        wrapper: KotlinOrderInfoWrapper,
        page: Int,
        size: Int
    ): List<KotlinOrderInfo>? {
        val departments = repository.findAll(PageRequest.of(if (page <= 1) 0 else page - 1, size))
        return departments.map { it }.toList()
    }

    override fun getPage(
        wrapper: KotlinOrderInfoWrapper,
        page: Int,
        size: Int
    ): Pagination<KotlinOrderInfo>? {
        return Pagination(repository.findAll(PageRequest.of(if (page <= 1) 0 else page - 1, size)))
    }
}