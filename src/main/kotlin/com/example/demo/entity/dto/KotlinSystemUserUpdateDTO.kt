package com.example.demo.entity.dto

open class KotlinSystemUserUpdateDTO {
    var id: Long? = null
    var username: String? = null
    var name: String? = null
    var state: Int? = null
    var roleIds: List<Long>? = null
}