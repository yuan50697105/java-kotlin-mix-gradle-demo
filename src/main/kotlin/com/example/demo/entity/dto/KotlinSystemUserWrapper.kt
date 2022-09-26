package com.example.demo.entity.dto

import com.example.demo.entity.KotlinSystemUser

class KotlinSystemUserWrapper : KotlinSystemUser() {
    var ids: List<Long>? = null
}