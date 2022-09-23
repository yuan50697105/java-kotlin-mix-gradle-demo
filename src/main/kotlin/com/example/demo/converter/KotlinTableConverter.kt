package com.example.demo.converter

import com.example.demo.entity.JavaTable
import com.example.demo.entity.KotlinTable
import com.example.demo.entity.dto.JavaTableDTO
import com.example.demo.entity.dto.KotlinTableAddDTO
import com.example.demo.entity.dto.KotlinTableUpdateDTO
import org.mapstruct.Mapper
import org.mapstruct.ReportingPolicy
import org.mapstruct.factory.Mappers

@Mapper(
    componentModel = "spring",
    unmappedSourcePolicy = ReportingPolicy.IGNORE,
    unmappedTargetPolicy = ReportingPolicy.IGNORE
)
interface KotlinTableConverter {
    companion object {
        val kotlinTableConverter: KotlinTableConverter = Mappers.getMapper(KotlinTableConverter::class.java)
    }

    fun poToDto(javaTable: JavaTable): JavaTableDTO
    fun dtoToPo(javaTableDTO: JavaTableDTO): JavaTable
    fun convertForAdd(kotlinTableAddDTO: KotlinTableAddDTO): KotlinTable
    fun kotlinToJava(kotlinTable: KotlinTable): JavaTable
    fun javaToKotlin(javaTable: JavaTable): KotlinTable
    fun convertForUpdate(table: KotlinTableUpdateDTO): KotlinTable
}