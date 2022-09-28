package com.example.demo.converter

import com.example.demo.entity.KotlinCustomerInfo
import com.example.demo.entity.dto.KotlinCustomerInfoAddDTO
import com.example.demo.entity.dto.KotlinCustomerInfoUpdateDTO
import org.mapstruct.Mapper
import org.mapstruct.ReportingPolicy

@Mapper(
    componentModel = "spring",
    unmappedSourcePolicy = ReportingPolicy.IGNORE,
    unmappedTargetPolicy = ReportingPolicy.IGNORE
)
interface KotlinCustomerInfoConverter {
    fun convertForAdd(KotlinSystemUserAddDTO: KotlinCustomerInfoAddDTO): KotlinCustomerInfo
    fun convertForUpdate(table: KotlinCustomerInfoUpdateDTO): KotlinCustomerInfo
}