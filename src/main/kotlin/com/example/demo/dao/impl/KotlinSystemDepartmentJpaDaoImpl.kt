package com.example.demo.dao.impl

import com.example.demo.constants.JavaDaoType
import com.example.demo.dao.KotlinSystemDepartmentDao
import com.example.demo.entity.KotlinSystemDepartment
import com.example.demo.entity.dto.KotlinSystemDepartmentWrapper
import com.example.demo.entity.dto.Pagination
import com.example.demo.repository.KotlinSystemDepartmentRepository
import com.google.common.collect.Lists
import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class KotlinSystemDepartmentJpaDaoImpl(private val repository: KotlinSystemDepartmentRepository) :
    KotlinSystemDepartmentDao {
    override fun getType(): String {
        return JavaDaoType.JPA.name
    }

    @Transactional
    override fun saveData(javaSystemRole: KotlinSystemDepartment) {
        repository.save(javaSystemRole)
    }

    override fun updateData(javaSystemRole: KotlinSystemDepartment) {
        repository.save(javaSystemRole)
    }

    override fun get(id: Long): KotlinSystemDepartment {
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

    override fun getList(wrapper: KotlinSystemDepartmentWrapper): List<KotlinSystemDepartment>? {
        return repository.findAll()
    }

    override fun getList(
        wrapper: KotlinSystemDepartmentWrapper,
        page: Int,
        size: Int
    ): List<KotlinSystemDepartment>? {
        val departments = repository.findAll(PageRequest.of(if (page <= 1) 0 else page - 1, size))
        return departments.map { it }.toList()
    }

    override fun getPage(
        wrapper: KotlinSystemDepartmentWrapper,
        page: Int,
        size: Int
    ): Pagination<KotlinSystemDepartment>? {
        return Pagination(repository.findAll(PageRequest.of(if (page <= 1) 0 else page - 1, size)))
    }
}