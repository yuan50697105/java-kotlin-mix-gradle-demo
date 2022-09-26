package com.example.demo.dao.impl

import com.example.demo.constants.KotlinDaoType
import com.example.demo.dao.KotlinSystemRoleDao
import com.example.demo.dao.base.KotlinSystemRoleBaseDao
import com.example.demo.entity.KotlinSystemRole
import com.example.demo.entity.dto.KotlinSystemRoleWrapper
import com.example.demo.entity.dto.Pagination
import com.github.pagehelper.PageHelper
import com.github.pagehelper.PageInfo
import org.springframework.stereotype.Service
import javax.transaction.Transactional

@Service
class KotlinSystemRoleFluentDaoImpl : KotlinSystemRoleBaseDao(), KotlinSystemRoleDao {
    override fun getType(): String {
        return KotlinDaoType.FLUENT.name
    }

    @Transactional
    override fun updateData(kotlinTable: KotlinSystemRole) {
        this.updateById(kotlinTable)
    }

    override fun get(id: Long): KotlinSystemRole {
        return selectById(id)
    }

    override fun getPage(wrapper: KotlinSystemRoleWrapper, page: Int, size: Int): Pagination<KotlinSystemRole> {
        PageHelper.startPage<Any>(page, size)
        return Pagination(PageInfo.of(listEntity(query())))

    }

    @Transactional
    override fun deleteData(id: Array<Long>) {
        deleteByIds(id.asList())
    }

    override fun getList(wrapper: KotlinSystemRoleWrapper): List<KotlinSystemRole> {
        return listEntity(query())
    }

    @Transactional
    override fun saveData(kotlinTable: KotlinSystemRole) {
        this.save<KotlinSystemRole>(kotlinTable)
    }
}