package com.example.demo.entity.dto

import cn.org.atool.fluent.mybatis.base.RichEntity

open class KotlinSystemRoleUpdateDTO : RichEntity() {
    var id: Long? = null
    var name: String? = null
    var state: Int? = null
}