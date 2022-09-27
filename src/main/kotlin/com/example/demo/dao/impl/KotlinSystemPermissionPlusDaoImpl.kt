package com.example.demo.dao.impl

import com.baomidou.mybatisplus.extension.plugins.pagination.PageDTO
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl
import com.example.demo.constants.KotlinDaoType
import com.example.demo.dao.KotlinSystemPermissionDao
import com.example.demo.entity.KotlinSystemPermission
import com.example.demo.entity.dto.KotlinSystemPermissionWrapper
import com.example.demo.entity.dto.Pagination
import com.example.demo.mapper.KotlinSystemPermissionDaoMapper
import org.springframework.stereotype.Service
import javax.transaction.Transactional

@Service
class KotlinSystemPermissionPlusDaoImpl : ServiceImpl<KotlinSystemPermissionDaoMapper, KotlinSystemPermission>(),
    KotlinSystemPermissionDao {
    override fun getType(): String {
        return KotlinDaoType.PLUS.name
    }

    @Transactional
    override fun updateData(kotlinTable: KotlinSystemPermission) {
        this.updateById(kotlinTable)
    }

    override fun get(id: Long): KotlinSystemPermission {
        return getById(id)
    }

    override fun getList(wrapper: KotlinSystemPermissionWrapper): List<KotlinSystemPermission> {
        return ktQuery().list()
    }

    @Transactional
    override fun deleteData(id: Array<Long>) {
        this.removeByIds(id.asList())
    }

    override fun getPage(
        wrapper: KotlinSystemPermissionWrapper,
        page: Int,
        size: Int
    ): Pagination<KotlinSystemPermission> {
        return Pagination(ktQuery().page(PageDTO(page.toLong(), size.toLong())))
    }

    @Transactional
    override fun saveData(kotlinTable: KotlinSystemPermission) {
        this.save(kotlinTable)
    }

}