package com.example.demo.dao.api.impl

import com.example.demo.constants.JavaDaoType
import com.example.demo.dao.api.KotlinGoodsInfoDao
import com.example.demo.entity.KotlinGoodsInfo
import com.example.demo.entity.dto.KotlinGoodsInfoWrapper
import com.example.demo.entity.dto.Pagination
import com.example.demo.repository.KotlinGoodsInfoRepository
import com.google.common.collect.Lists
import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class KotlinGoodsInfoJpaDaoImpl(private val repository: KotlinGoodsInfoRepository) :
    KotlinGoodsInfoDao {
    override fun getType(): String {
        return JavaDaoType.JPA.name
    }

    @Transactional
    override fun saveData(javaSystemRole: KotlinGoodsInfo) {
        repository.save(javaSystemRole)
    }

    override fun updateData(javaSystemRole: KotlinGoodsInfo) {
        repository.save(javaSystemRole)
    }

    override fun get(id: Long): KotlinGoodsInfo {
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

    override fun getList(wrapper: KotlinGoodsInfoWrapper): List<KotlinGoodsInfo>? {
        return repository.findAll()
    }

    override fun getList(
        wrapper: KotlinGoodsInfoWrapper,
        page: Int,
        size: Int
    ): List<KotlinGoodsInfo>? {
        val departments = repository.findAll(PageRequest.of(if (page <= 1) 0 else page - 1, size))
        return departments.map { it }.toList()
    }

    override fun getPage(
        wrapper: KotlinGoodsInfoWrapper,
        page: Int,
        size: Int
    ): Pagination<KotlinGoodsInfo>? {
        return Pagination(repository.findAll(PageRequest.of(if (page <= 1) 0 else page - 1, size)))
    }
}