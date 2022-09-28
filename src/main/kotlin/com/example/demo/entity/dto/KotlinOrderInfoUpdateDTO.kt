package com.example.demo.entity.dto

import java.math.BigDecimal


open class KotlinOrderInfoUpdateDTO  {
    var id: Long? = null
    var code: String? = null
    var customerId: Long? = null
    var totalPrice: BigDecimal? = null
    var type: Int? = null
    var state: Int? = null

}