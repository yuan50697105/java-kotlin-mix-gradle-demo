package com.example.demo.converter;

import com.example.demo.entity.JavaCustomerInfo;
import com.example.demo.entity.dto.JavaCustomerInfoAddDTO;
import com.example.demo.entity.dto.JavaCustomerInfoUpdateDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedSourcePolicy = ReportingPolicy.IGNORE, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface JavaCustomerInfoConverter {


    JavaCustomerInfo convertForAdd(JavaCustomerInfoAddDTO javaSystemUserAddDTO);

    JavaCustomerInfo convertForUpdate(JavaCustomerInfoUpdateDTO table);
}
