package com.example.demo.dao.factory

import cn.hutool.core.lang.tree.Tree
import com.example.demo.entity.KotlinSystemPermission
import com.example.demo.entity.dto.KotlinSystemPermissionWrapper
import com.example.demo.entity.dto.Pagination

interface KotlinSystemPermissionDaoFactory {
    fun saveData(kotlinTable: KotlinSystemPermission, type: String)
    fun updateData(convertForUpdate: KotlinSystemPermission, type: String)
    fun get(id: Long, type: String): KotlinSystemPermission?
    fun getList(wrapper: KotlinSystemPermissionWrapper, type: String): List<KotlinSystemPermission>?
    fun getPage(
        wrapper: KotlinSystemPermissionWrapper,
        page: Int,
        size: Int,
        type: String
    ): Pagination<KotlinSystemPermission>?

    fun deleteData(id: Array<Long>, type: String)
    fun getTree(type: String, wrapper: KotlinSystemPermissionWrapper): List<Tree<Long?>>?

}