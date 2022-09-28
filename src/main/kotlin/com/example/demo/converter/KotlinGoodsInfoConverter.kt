package com.example.demo.converter

import com.example.demo.entity.KotlinGoodsInfo
import com.example.demo.entity.dto.KotlinGoodsInfoAddDTO
import com.example.demo.entity.dto.KotlinGoodsInfoUpdateDTO
import org.mapstruct.Mapper
import org.mapstruct.ReportingPolicy

@Mapper(
    componentModel = "spring",
    unmappedSourcePolicy = ReportingPolicy.IGNORE,
    unmappedTargetPolicy = ReportingPolicy.IGNORE
)
interface KotlinGoodsInfoConverter {
    fun convertForAdd(KotlinSystemUserAddDTO: KotlinGoodsInfoAddDTO): KotlinGoodsInfo
    fun convertForUpdate(table: KotlinGoodsInfoUpdateDTO): KotlinGoodsInfo
}