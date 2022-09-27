package com.example.demo.dao.impl

import com.example.demo.constants.KotlinDaoType
import com.example.demo.dao.KotlinSystemRoleDao
import com.example.demo.entity.KotlinSystemRole
import com.example.demo.entity.dto.KotlinSystemRoleWrapper
import com.example.demo.entity.dto.Pagination
import com.example.demo.repository.KotlinSystemRoleRepository
import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class KotlinSystemRoleJpaDaoImpl(private val kotlinSystemUserRepository: KotlinSystemRoleRepository) :
    KotlinSystemRoleDao {
    override fun getType(): String {
        return KotlinDaoType.JPA.name
    }

    @Transactional
    override fun updateData(kotlinTable: KotlinSystemRole) {
        kotlinSystemUserRepository.save(kotlinTable)
    }

    override fun get(id: Long): KotlinSystemRole {
        return kotlinSystemUserRepository.findById(id).orElse(null)
    }

    override fun getList(wrapper: KotlinSystemRoleWrapper): List<KotlinSystemRole> {
        return kotlinSystemUserRepository.findAll()
    }

    override fun getPage(wrapper: KotlinSystemRoleWrapper, page: Int, size: Int): Pagination<KotlinSystemRole> {
        val pageIndex = if (page <= 1) 0 else page - 1
        return Pagination(kotlinSystemUserRepository.findAll(PageRequest.of(pageIndex, size)))
    }

    override fun deleteData(id: Array<Long>) {
        kotlinSystemUserRepository.deleteAllById(id.asList())
    }

    @Transactional
    override fun saveData(kotlinTable: KotlinSystemRole) {
        kotlinSystemUserRepository.save(kotlinTable)
    }
}