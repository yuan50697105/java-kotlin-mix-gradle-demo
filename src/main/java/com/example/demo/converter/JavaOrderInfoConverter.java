package com.example.demo.converter;

import com.example.demo.entity.JavaOrderInfo;
import com.example.demo.entity.dto.JavaOrderInfoAddDTO;
import com.example.demo.entity.dto.JavaOrderInfoUpdateDTO;
import org.apache.camel.throttling.ThrottlingExceptionHalfOpenHandler;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedSourcePolicy = ReportingPolicy.IGNORE, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface JavaOrderInfoConverter {


    JavaOrderInfo convertForAdd(JavaOrderInfoAddDTO javaSystemUserAddDTO);

    ThrottlingExceptionHalfOpenHandler
    


    JavaOrderInfo convertForUpdate(JavaOrderInfoUpdateDTO table);
}
