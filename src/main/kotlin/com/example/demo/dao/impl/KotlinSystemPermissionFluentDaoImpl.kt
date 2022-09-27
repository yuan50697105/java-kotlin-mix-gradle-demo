package com.example.demo.dao.impl

import com.example.demo.constants.KotlinDaoType
import com.example.demo.dao.KotlinSystemPermissionDao
import com.example.demo.dao.base.KotlinSystemPermissionBaseDao
import com.example.demo.entity.KotlinSystemPermission
import com.example.demo.entity.dto.KotlinSystemPermissionWrapper
import com.example.demo.entity.dto.Pagination
import com.github.pagehelper.PageHelper
import com.github.pagehelper.PageInfo
import org.springframework.stereotype.Service
import javax.transaction.Transactional

@Service
class KotlinSystemPermissionFluentDaoImpl : KotlinSystemPermissionBaseDao(), KotlinSystemPermissionDao {
    override fun getType(): String {
        return KotlinDaoType.FLUENT.name
    }

    @Transactional
    override fun updateData(kotlinTable: KotlinSystemPermission) {
        this.updateById(kotlinTable)
    }

    override fun get(id: Long): KotlinSystemPermission {
        return selectById(id)
    }

    override fun getPage(
        wrapper: KotlinSystemPermissionWrapper,
        page: Int,
        size: Int
    ): Pagination<KotlinSystemPermission> {
        PageHelper.startPage<Any>(page, size)
        return Pagination(PageInfo.of(listEntity(query())))

    }

    @Transactional
    override fun deleteData(id: Array<Long>) {
        deleteByIds(id.asList())
    }

    override fun getList(wrapper: KotlinSystemPermissionWrapper): List<KotlinSystemPermission> {
        return listEntity(query())
    }

    @Transactional
    override fun saveData(kotlinTable: KotlinSystemPermission) {
        this.save<KotlinSystemPermission>(kotlinTable)
    }

}