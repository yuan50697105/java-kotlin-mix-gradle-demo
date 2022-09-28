package com.example.demo.dao.api.impl

import com.example.demo.constants.KotlinDaoType
import com.example.demo.dao.api.KotlinSystemUserDao
import com.example.demo.dao.base.KotlinSystemUserBaseDao
import com.example.demo.entity.KotlinSystemUser
import com.example.demo.entity.dto.KotlinSystemUserWrapper
import com.example.demo.entity.dto.Pagination
import com.github.pagehelper.PageHelper
import com.github.pagehelper.PageInfo
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class KotlinSystemUserFluentDaoImpl : KotlinSystemUserBaseDao(), KotlinSystemUserDao {
    override fun getType(): String {
        return KotlinDaoType.FLUENT.name
    }

    @Transactional
    override fun updateData(kotlinTable: KotlinSystemUser) {
        this.updateById(kotlinTable)
    }

    override fun get(id: Long): KotlinSystemUser {
        return selectById(id)
    }

    override fun getPage(wrapper: KotlinSystemUserWrapper, page: Int, size: Int): Pagination<KotlinSystemUser> {
        PageHelper.startPage<Any>(page, size)
        return Pagination(PageInfo.of(listEntity(query())))

    }

    @Transactional
    override fun deleteData(id: Array<Long>) {
        deleteByIds(id.asList())
    }

    override fun getList(wrapper: KotlinSystemUserWrapper): List<KotlinSystemUser> {
        return listEntity(query())
    }

    @Transactional
    override fun saveData(kotlinTable: KotlinSystemUser) {
        this.save<KotlinSystemUser>(kotlinTable)
    }
}