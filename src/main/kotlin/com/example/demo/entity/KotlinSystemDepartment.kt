package com.example.demo.entity

import cn.org.atool.fluent.mybatis.annotation.FluentMybatis
import cn.org.atool.fluent.mybatis.base.RichEntity
import com.baomidou.mybatisplus.annotation.TableName
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table


@Entity
@Table(name = "system_department")
@TableName("system_department")
@FluentMybatis(table = "system_department")
open class KotlinSystemDepartment : RichEntity() {
    @Id
    var id: Long? = null
    var name: String? = null
    var state: Int? = null
    var parentId: Long? = null

    enum class DepartmentState(val code: Int, val value: String) {
        ENABLE(1, "启用"), DISABLE(0, "停用");

        companion object {
            fun getState(value: String?): JavaSystemDepartment.DepartmentState {
                for (departmentState in JavaSystemDepartment.DepartmentState.values()) {
                    if (departmentState.code.toString().equals(value, ignoreCase = true) || departmentState.name.equals(
                            value,
                            ignoreCase = true
                        )
                    ) {
                        return departmentState
                    }
                }
                throw IllegalArgumentException(value)
            }

            fun getCode(state: DepartmentState): Int {
                return state.code
            }
        }
    }
}