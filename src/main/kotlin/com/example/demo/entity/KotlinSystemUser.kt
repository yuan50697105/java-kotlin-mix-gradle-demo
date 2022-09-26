package com.example.demo.entity

import cn.org.atool.fluent.mybatis.annotation.FluentMybatis
import cn.org.atool.fluent.mybatis.base.RichEntity
import com.baomidou.mybatisplus.annotation.TableName
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@FluentMybatis(table = "system_user")
@TableName("system_user")
@Entity
@Table(name = "system_user")
open class KotlinSystemUser : RichEntity() {
    @Id
    var id: Long? = null
    var username: String? = null
    var password: String? = null
    var name: String? = null
    var state: Int? = null
}