package com.example.demo.converter

import com.example.demo.entity.KotlinSystemPermission
import com.example.demo.entity.dto.KotlinSystemPermissionAddDTO
import com.example.demo.entity.dto.KotlinSystemPermissionUpdateDTO
import org.mapstruct.Mapper
import org.mapstruct.ReportingPolicy

@Mapper(
    componentModel = "spring",
    unmappedSourcePolicy = ReportingPolicy.IGNORE,
    unmappedTargetPolicy = ReportingPolicy.IGNORE
)
interface KotlinSystemPermissionConverter {


    fun convertForAdd(table: KotlinSystemPermissionAddDTO): KotlinSystemPermission
    fun convertForUpdate(table: KotlinSystemPermissionUpdateDTO): KotlinSystemPermission
}