package com.example.demo.dao.impl

import com.example.demo.constants.KotlinDaoType
import com.example.demo.dao.KotlinSystemPermissionDao
import com.example.demo.entity.KotlinSystemPermission
import com.example.demo.entity.dto.KotlinSystemPermissionWrapper
import com.example.demo.entity.dto.Pagination
import com.example.demo.repository.KotlinSystemPermissionRepository
import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Service
import javax.transaction.Transactional

@Service
class KotlinSystemPermissionJpaDaoImpl(private val repository: KotlinSystemPermissionRepository) :
    KotlinSystemPermissionDao {
    override fun getType(): String {
        return KotlinDaoType.JPA.name
    }

    @Transactional
    override fun updateData(kotlinTable: KotlinSystemPermission) {
        repository.save(kotlinTable)
    }

    override fun get(id: Long): KotlinSystemPermission {
        return repository.findById(id).orElse(null)
    }

    override fun getList(wrapper: KotlinSystemPermissionWrapper): List<KotlinSystemPermission> {
        return repository.findAll()
    }

    override fun getPage(
        wrapper: KotlinSystemPermissionWrapper,
        page: Int,
        size: Int
    ): Pagination<KotlinSystemPermission> {
        val pageIndex = if (page <= 1) 0 else page - 1
        return Pagination(repository.findAll(PageRequest.of(pageIndex, size)))
    }

    override fun deleteData(id: Array<Long>) {
        repository.deleteAllById(id.asList())
    }

    @Transactional
    override fun saveData(kotlinTable: KotlinSystemPermission) {
        repository.save(kotlinTable)
    }
}