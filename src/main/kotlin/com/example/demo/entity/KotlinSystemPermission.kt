package com.example.demo.entity

import cn.org.atool.fluent.mybatis.annotation.FluentMybatis
import cn.org.atool.fluent.mybatis.base.RichEntity
import com.baomidou.mybatisplus.annotation.TableName
import javax.persistence.Id
import javax.persistence.Table

@Table(name = "system_permission")
@FluentMybatis(table = "system_permission")
@TableName("system_permission")
open class KotlinSystemPermission : RichEntity() {
    @Id
    var id: Long? = null
    var name: String? = null
    var type: Int? = null

    enum class PermissionType(private val code: Int, private val value: String) {
        MENU(1, "菜单");

        operator fun get(value: String?): JavaSystemPermission.PermissionType {
            for (permissionType in JavaSystemPermission.PermissionType.values()) {
                if (permissionType.code.toString().equals(value, ignoreCase = true) || permissionType.name.equals(
                        value,
                        ignoreCase = true
                    )
                ) {
                    return permissionType
                }
            }
            throw IllegalArgumentException(value)
        }

        fun getCode(permissionType: PermissionType): Int {
            return permissionType.code
        }
    }
}