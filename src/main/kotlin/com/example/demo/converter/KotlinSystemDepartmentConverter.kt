package com.example.demo.converter

import com.example.demo.entity.KotlinSystemDepartment
import com.example.demo.entity.dto.KotlinSystemDepartmentAddDTO
import com.example.demo.entity.dto.KotlinSystemDepartmentUpdateDTO
import org.mapstruct.Mapper
import org.mapstruct.ReportingPolicy

@Mapper(
    componentModel = "spring",
    unmappedSourcePolicy = ReportingPolicy.IGNORE,
    unmappedTargetPolicy = ReportingPolicy.IGNORE
)
interface KotlinSystemDepartmentConverter {
    fun convertForAdd(KotlinSystemUserAddDTO: KotlinSystemDepartmentAddDTO): KotlinSystemDepartment
    fun convertForUpdate(table: KotlinSystemDepartmentUpdateDTO): KotlinSystemDepartment
}