package com.example.demo.dao.api.impl

import com.baomidou.mybatisplus.extension.plugins.pagination.PageDTO
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl
import com.example.demo.constants.KotlinDaoType
import com.example.demo.dao.api.KotlinSystemUserDao
import com.example.demo.entity.KotlinSystemUser
import com.example.demo.entity.dto.KotlinSystemUserWrapper
import com.example.demo.entity.dto.Pagination
import com.example.demo.mapper.KotlinSystemUserDaoMapper
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class KotlinSystemUserPlusDaoImpl : ServiceImpl<KotlinSystemUserDaoMapper, KotlinSystemUser>(), KotlinSystemUserDao {
    override fun getType(): String {
        return KotlinDaoType.PLUS.name
    }

    @Transactional
    override fun updateData(kotlinTable: KotlinSystemUser) {
        this.updateById(kotlinTable)
    }

    override fun get(id: Long): KotlinSystemUser {
        return getById(id)
    }

    override fun getList(wrapper: KotlinSystemUserWrapper): List<KotlinSystemUser> {
        return ktQuery().list()
    }

    @Transactional
    override fun deleteData(id: Array<Long>) {
        this.removeByIds(id.asList())
    }

    override fun getPage(wrapper: KotlinSystemUserWrapper, page: Int, size: Int): Pagination<KotlinSystemUser> {
        return Pagination(ktQuery().page(PageDTO(page.toLong(), size.toLong())))
    }

    @Transactional
    override fun saveData(kotlinTable: KotlinSystemUser) {
        this.save(kotlinTable)
    }
}