package com.example.demo.converter

import com.example.demo.entity.JavaTable
import com.example.demo.entity.KotlinSystemUser
import com.example.demo.entity.dto.JavaTableDTO
import com.example.demo.entity.dto.KotlinSystemUserAddDTO
import com.example.demo.entity.dto.KotlinSystemUserUpdateDTO
import org.mapstruct.Mapper
import org.mapstruct.ReportingPolicy
import org.mapstruct.factory.Mappers

@Mapper(
    componentModel = "spring",
    unmappedSourcePolicy = ReportingPolicy.IGNORE,
    unmappedTargetPolicy = ReportingPolicy.IGNORE
)
interface KotlinSystemUserConverter {
    companion object {
        val kotlinTableConverter: KotlinSystemUserConverter = Mappers.getMapper(KotlinSystemUserConverter::class.java)
    }

    fun poToDto(javaTable: JavaTable): JavaTableDTO
    fun dtoToPo(javaTableDTO: JavaTableDTO): JavaTable
    fun convertForAdd(kotlinTableAddDTO: KotlinSystemUserAddDTO): KotlinSystemUser
    fun convertForUpdate(table: KotlinSystemUserUpdateDTO): KotlinSystemUser
}