package com.example.demo.converter

import com.example.demo.entity.JavaTable
import com.example.demo.entity.dto.JavaTableDTO
import org.mapstruct.Mapper

@Mapper(componentModel = "spring")
interface KotlinTableConverter {
    fun poToDto(javaTable: JavaTable): JavaTableDTO
    fun dtoToPo(javaTableDTO: JavaTableDTO): JavaTable
}