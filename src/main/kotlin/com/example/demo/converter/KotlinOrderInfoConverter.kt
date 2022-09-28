package com.example.demo.converter

import com.example.demo.entity.KotlinOrderInfo
import com.example.demo.entity.dto.KotlinOrderInfoAddDTO
import com.example.demo.entity.dto.KotlinOrderInfoUpdateDTO
import org.mapstruct.Mapper
import org.mapstruct.ReportingPolicy

@Mapper(
    componentModel = "spring",
    unmappedSourcePolicy = ReportingPolicy.IGNORE,
    unmappedTargetPolicy = ReportingPolicy.IGNORE
)
interface KotlinOrderInfoConverter {
    fun convertForAdd(KotlinSystemUserAddDTO: KotlinOrderInfoAddDTO): KotlinOrderInfo
    fun convertForUpdate(table: KotlinOrderInfoUpdateDTO): KotlinOrderInfo
}