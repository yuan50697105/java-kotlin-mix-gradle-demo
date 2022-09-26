package com.example.demo.converter

import com.example.demo.entity.KotlinSystemUser
import com.example.demo.entity.dto.KotlinSystemUserAddDTO
import com.example.demo.entity.dto.KotlinSystemUserUpdateDTO
import org.mapstruct.Mapper
import org.mapstruct.ReportingPolicy

@Mapper(
    componentModel = "spring",
    unmappedSourcePolicy = ReportingPolicy.IGNORE,
    unmappedTargetPolicy = ReportingPolicy.IGNORE
)
interface KotlinSystemUserConverter {

    fun convertForAdd(kotlinTableAddDTO: KotlinSystemUserAddDTO): KotlinSystemUser
    fun convertForUpdate(table: KotlinSystemUserUpdateDTO): KotlinSystemUser
}