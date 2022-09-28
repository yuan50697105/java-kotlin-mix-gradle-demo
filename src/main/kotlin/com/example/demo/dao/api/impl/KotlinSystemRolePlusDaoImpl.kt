package com.example.demo.dao.api.impl

import com.baomidou.mybatisplus.extension.plugins.pagination.PageDTO
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl
import com.example.demo.constants.KotlinDaoType
import com.example.demo.dao.api.KotlinSystemRoleDao
import com.example.demo.entity.KotlinSystemRole
import com.example.demo.entity.dto.KotlinSystemRoleWrapper
import com.example.demo.entity.dto.Pagination
import com.example.demo.mapper.KotlinSystemRoleDaoMapper
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class KotlinSystemRolePlusDaoImpl : ServiceImpl<KotlinSystemRoleDaoMapper, KotlinSystemRole>(), KotlinSystemRoleDao {
    override fun getType(): String {
        return KotlinDaoType.PLUS.name
    }

    @Transactional
    override fun updateData(kotlinTable: KotlinSystemRole) {
        this.updateById(kotlinTable)
    }

    override fun get(id: Long): KotlinSystemRole {
        return getById(id)
    }

    override fun getList(wrapper: KotlinSystemRoleWrapper): List<KotlinSystemRole> {
        return ktQuery().list()
    }

    @Transactional
    override fun deleteData(id: Array<Long>) {
        this.removeByIds(id.asList())
    }

    override fun getPage(wrapper: KotlinSystemRoleWrapper, page: Int, size: Int): Pagination<KotlinSystemRole> {
        return Pagination(ktQuery().page(PageDTO(page.toLong(), size.toLong())))
    }

    @Transactional
    override fun saveData(kotlinTable: KotlinSystemRole) {
        this.save(kotlinTable)
    }

}