package com.example.demo.converter;

import com.example.demo.entity.JavaGoodsInfo;
import com.example.demo.entity.dto.JavaGoodsInfoAddDTO;
import com.example.demo.entity.dto.JavaGoodsInfoUpdateDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedSourcePolicy = ReportingPolicy.IGNORE, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface JavaGoodsInfoConverter {


    JavaGoodsInfo convertForAdd(JavaGoodsInfoAddDTO javaSystemUserAddDTO);

    JavaGoodsInfo convertForUpdate(JavaGoodsInfoUpdateDTO table);
}
