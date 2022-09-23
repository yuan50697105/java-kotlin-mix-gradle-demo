package com.example.demo.entity

import cn.org.atool.fluent.mybatis.annotation.FluentMybatis
import cn.org.atool.fluent.mybatis.base.RichEntity

@FluentMybatis
class KotlinTable : RichEntity() {

    var id: Long? = null

    companion object{
        const val a = "aaa"

    }
}