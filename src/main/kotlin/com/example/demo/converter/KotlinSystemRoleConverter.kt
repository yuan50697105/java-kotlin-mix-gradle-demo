package com.example.demo.converter

import com.example.demo.entity.KotlinSystemRole
import com.example.demo.entity.dto.KotlinSystemRoleAddDTO
import com.example.demo.entity.dto.KotlinSystemRoleUpdateDTO
import org.mapstruct.Mapper
import org.mapstruct.ReportingPolicy

@Mapper(
    componentModel = "spring",
    unmappedSourcePolicy = ReportingPolicy.IGNORE,
    unmappedTargetPolicy = ReportingPolicy.IGNORE
)
interface KotlinSystemRoleConverter {


    fun convertForAdd(kotlinTableAddDTO: KotlinSystemRoleAddDTO): KotlinSystemRole
    fun convertForUpdate(table: KotlinSystemRoleUpdateDTO): KotlinSystemRole
}