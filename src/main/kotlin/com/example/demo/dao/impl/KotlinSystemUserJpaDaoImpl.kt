package com.example.demo.dao.impl

import com.example.demo.constants.KotlinDaoType
import com.example.demo.dao.KotlinSystemUserDao
import com.example.demo.entity.KotlinSystemUser
import com.example.demo.entity.dto.KotlinSystemUserWrapper
import com.example.demo.entity.dto.Pagination
import com.example.demo.repository.KotlinSystemUserRepository
import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class KotlinSystemUserJpaDaoImpl(private val kotlinSystemUserRepository: KotlinSystemUserRepository) :
    KotlinSystemUserDao {
    override fun getType(): String {
        return KotlinDaoType.JPA.name
    }

    @Transactional
    override fun updateData(kotlinTable: KotlinSystemUser) {
        kotlinSystemUserRepository.save(kotlinTable)
    }

    override fun get(id: Long): KotlinSystemUser {
        return kotlinSystemUserRepository.findById(id).orElse(null)
    }

    override fun getList(wrapper: KotlinSystemUserWrapper): List<KotlinSystemUser> {
        return kotlinSystemUserRepository.findAll()
    }

    override fun getPage(wrapper: KotlinSystemUserWrapper, page: Int, size: Int): Pagination<KotlinSystemUser> {
        val pageIndex = if (page <= 1) 0 else page - 1
        return Pagination(kotlinSystemUserRepository.findAll(PageRequest.of(pageIndex, size)))
    }

    override fun deleteData(id: Array<Long>) {
        kotlinSystemUserRepository.deleteAllById(id.asList())
    }

    @Transactional
    override fun saveData(kotlinTable: KotlinSystemUser) {
        kotlinSystemUserRepository.save(kotlinTable)
    }
}