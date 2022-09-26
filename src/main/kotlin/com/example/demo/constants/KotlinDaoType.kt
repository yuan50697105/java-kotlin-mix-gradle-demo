package com.example.demo.constants

enum class KotlinDaoType {
    PLUS,
    FLUENT,
    JPA
    ;

    companion object {
        fun getType(type: String): String {
            for (value in values()) {
                if (value.name.lowercase() == type.lowercase()) {
                    return value.name
                }

            }
            throw IllegalArgumentException(type)
        }
    }
}