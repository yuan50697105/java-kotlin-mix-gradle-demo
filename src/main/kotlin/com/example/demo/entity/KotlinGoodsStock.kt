package com.example.demo.entity

import cn.org.atool.fluent.mybatis.annotation.FluentMybatis
import cn.org.atool.fluent.mybatis.base.RichEntity
import com.baomidou.mybatisplus.annotation.TableName
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

/**
 * 商品库存
 */
@Entity
@Table(name = "goods_stock")
@TableName("goods_stock")
@FluentMybatis(table = "goods_stock")
open class KotlinGoodsStock : RichEntity() {
    @Id
    var id: Long? = null
    var goodsId: String? = null
    var name: String? = null
    var num: Int? = null
}