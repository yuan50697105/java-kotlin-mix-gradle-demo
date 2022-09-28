package com.example.demo.entity

import cn.org.atool.fluent.mybatis.annotation.FluentMybatis
import cn.org.atool.fluent.mybatis.base.RichEntity
import com.baomidou.mybatisplus.annotation.TableName
import java.math.BigDecimal
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "order_detail")
@TableName("order_detail")
@FluentMybatis(table = "order_detail")
open class KotlinOrderDetail : RichEntity() {
    @Id
    var id: Long? = null
    var orderId: Long? = null
    var orderCode: String? = null
    var goodsId: Long? = null
    var price: BigDecimal? = null
    var num: Int? = null
}