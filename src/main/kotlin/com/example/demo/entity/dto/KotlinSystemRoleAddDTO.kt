package com.example.demo.entity.dto

import cn.org.atool.fluent.mybatis.base.RichEntity

open class KotlinSystemRoleAddDTO : RichEntity() {
    var name: String? = null
    var permissionIds: List<Long>? = null
}