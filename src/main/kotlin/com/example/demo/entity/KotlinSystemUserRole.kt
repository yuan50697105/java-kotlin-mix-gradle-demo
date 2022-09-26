package com.example.demo.entity

import cn.org.atool.fluent.mybatis.annotation.FluentMybatis
import cn.org.atool.fluent.mybatis.base.RichEntity
import com.baomidou.mybatisplus.annotation.TableName
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "system_user_role")
@FluentMybatis(table = "system_user_role")
@TableName("system_user_role")
open class KotlinSystemUserRole : RichEntity() {
    @Id
    var id: Long? = null
    var roleId: Long? = null
    var userId: Long? = null
}