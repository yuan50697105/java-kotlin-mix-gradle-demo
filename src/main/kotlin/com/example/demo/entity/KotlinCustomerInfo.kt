package com.example.demo.entity

import cn.org.atool.fluent.mybatis.annotation.FluentMybatis
import cn.org.atool.fluent.mybatis.base.RichEntity
import com.baomidou.mybatisplus.annotation.TableName
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "customer_info")
@TableName("customer_info")
@FluentMybatis(table = "customer_info")
open class KotlinCustomerInfo : RichEntity() {
    @Id
    var id: Long? = null
    var code: String? = null
    var name: String? = null
    var type: Int? = null
    var state: Int? = null

    enum class CustomerType(val code: Int, val value: String) {
        COMMONS(0, "普通客户");

    }

    enum class CustomerState(val code: Int, val value: String) {
        NO_CONTRACT(0, "未签约"), CONTRACT(0, "已签约"), CONTRACT_TIME_OUT(0, "签约已失效");

    }
}