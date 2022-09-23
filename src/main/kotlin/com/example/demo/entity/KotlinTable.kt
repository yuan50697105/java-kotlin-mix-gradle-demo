package com.example.demo.entity

import cn.org.atool.fluent.mybatis.annotation.FluentMybatis
import cn.org.atool.fluent.mybatis.base.RichEntity

@FluentMybatis
open class KotlinTable : RichEntity() {
    var id: Long? = null
    var username: String? = null
    var password: String? = null

}