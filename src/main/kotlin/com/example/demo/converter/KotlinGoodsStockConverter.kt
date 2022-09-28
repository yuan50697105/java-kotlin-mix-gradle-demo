package com.example.demo.converter

import com.example.demo.entity.KotlinGoodsStock
import com.example.demo.entity.dto.KotlinGoodsStockAddDTO
import com.example.demo.entity.dto.KotlinGoodsStockUpdateDTO
import org.mapstruct.Mapper
import org.mapstruct.ReportingPolicy

@Mapper(
    componentModel = "spring",
    unmappedSourcePolicy = ReportingPolicy.IGNORE,
    unmappedTargetPolicy = ReportingPolicy.IGNORE
)
interface KotlinGoodsStockConverter {
    fun convertForAdd(KotlinSystemUserAddDTO: KotlinGoodsStockAddDTO): KotlinGoodsStock
    fun convertForUpdate(table: KotlinGoodsStockUpdateDTO): KotlinGoodsStock
}