package com.example.demo.entity

import cn.org.atool.fluent.mybatis.annotation.FluentMybatis
import cn.org.atool.fluent.mybatis.base.RichEntity
import com.baomidou.mybatisplus.annotation.TableName
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "system_role_permission")
@TableName("system_role_permission")
@FluentMybatis(table = "system_role_permission")
class KotlinSystemRolePermission : RichEntity() {

    @Id
    var id: Long? = null
    var roleId: Long? = null
    var permissionId: Long? = null
}