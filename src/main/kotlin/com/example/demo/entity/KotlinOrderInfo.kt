package com.example.demo.entity

import cn.org.atool.fluent.mybatis.annotation.FluentMybatis
import cn.org.atool.fluent.mybatis.base.RichEntity
import com.baomidou.mybatisplus.annotation.TableName
import java.math.BigDecimal
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "order_info")
@TableName("order_info")
@FluentMybatis(table = "order_info")
open class KotlinOrderInfo : RichEntity() {
    @Id
    var id: Long? = null
    var code: String? = null
    var customerId: Long? = null
    var totalPrice: BigDecimal? = null
    var type: Int? = null
    var state: Int? = null

    enum class OrderState(val code: Int, val value: String) {
        CREATED(0, "已创建"), CANCEL(1, "已取消"), TIMEOUT(2, "已超时"), PAID(3, "已付款"), TRANSFORM(4, "运输中"), COMPLETED(
            5,
            "已完成"
        );

    }

    enum class OrderType(val code: Int, val value: String, val desc: String) {
        COMMONS(0, "普通单", "没有详情"), DETAIL(1, "详情单", "有明细"), VIRTUAL(2, "虚拟服务", "无需配送，直接完成");

    }
}