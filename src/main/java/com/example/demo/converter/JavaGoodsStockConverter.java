package com.example.demo.converter;

import com.example.demo.entity.JavaGoodsStock;
import com.example.demo.entity.dto.JavaGoodsStockAddDTO;
import com.example.demo.entity.dto.JavaGoodsStockUpdateDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedSourcePolicy = ReportingPolicy.IGNORE, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface JavaGoodsStockConverter {


    JavaGoodsStock convertForAdd(JavaGoodsStockAddDTO javaSystemUserAddDTO);

    JavaGoodsStock convertForUpdate(JavaGoodsStockUpdateDTO table);
}
