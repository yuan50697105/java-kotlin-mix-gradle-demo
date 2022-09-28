package com.example.demo.dao.api.impl

import com.example.demo.constants.JavaDaoType
import com.example.demo.dao.api.KotlinCustomerInfoDao
import com.example.demo.entity.KotlinCustomerInfo
import com.example.demo.entity.dto.KotlinCustomerInfoWrapper
import com.example.demo.entity.dto.Pagination
import com.example.demo.repository.KotlinCustomerInfoRepository
import com.google.common.collect.Lists
import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class KotlinCustomerInfoJpaDaoImpl(private val repository: KotlinCustomerInfoRepository) :
    KotlinCustomerInfoDao {
    override fun getType(): String {
        return JavaDaoType.JPA.name
    }

    @Transactional
    override fun saveData(javaSystemRole: KotlinCustomerInfo) {
        repository.save(javaSystemRole)
    }

    override fun updateData(javaSystemRole: KotlinCustomerInfo) {
        repository.save(javaSystemRole)
    }

    override fun get(id: Long): KotlinCustomerInfo {
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

    override fun getList(wrapper: KotlinCustomerInfoWrapper): List<KotlinCustomerInfo>? {
        return repository.findAll()
    }

    override fun getList(
        wrapper: KotlinCustomerInfoWrapper,
        page: Int,
        size: Int
    ): List<KotlinCustomerInfo>? {
        val departments = repository.findAll(PageRequest.of(if (page <= 1) 0 else page - 1, size))
        return departments.map { it }.toList()
    }

    override fun getPage(
        wrapper: KotlinCustomerInfoWrapper,
        page: Int,
        size: Int
    ): Pagination<KotlinCustomerInfo>? {
        return Pagination(repository.findAll(PageRequest.of(if (page <= 1) 0 else page - 1, size)))
    }
}