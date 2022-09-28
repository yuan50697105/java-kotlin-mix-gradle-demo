package com.example.demo.entity

import cn.org.atool.fluent.mybatis.annotation.FluentMybatis
import cn.org.atool.fluent.mybatis.base.RichEntity
import com.baomidou.mybatisplus.annotation.TableName
import java.math.BigDecimal
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "goods_info")
@TableName("goods_info")
@FluentMybatis(table = "goods_info")
open class KotlinGoodsInfo : RichEntity() {
    @Id
    var id: Long? = null
    var code: String? = null
    var name: String? = null
    var price: BigDecimal? = null
    var state: Int? = null

    enum class GoodsState(val code: Int, val value: String) {
        CREATED(0, "已创建"), ONLINE(1, "已上架"), OFFLINE(2, "已下架");

        companion object {
            operator fun get(value: String?): GoodsState {
                for (goodsState in values()) {
                    if (goodsState.code.toString().equals(value, ignoreCase = true) || goodsState.value.equals(
                            value,
                            ignoreCase = true
                        )
                    ) {
                        return goodsState
                    }
                }
                throw IllegalArgumentException(value)
            }
        }
    }
}