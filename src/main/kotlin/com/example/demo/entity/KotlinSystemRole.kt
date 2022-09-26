package com.example.demo.entity

import cn.org.atool.fluent.mybatis.annotation.FluentMybatis
import cn.org.atool.fluent.mybatis.base.RichEntity
import com.baomidou.mybatisplus.annotation.TableName
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "system_role")
@FluentMybatis(table = "system_role")
@TableName("system_role")
open class KotlinSystemRole : RichEntity() {
    @Id
    var id: Long? = null
    var name: String? = null
    var state: Int? = null
}