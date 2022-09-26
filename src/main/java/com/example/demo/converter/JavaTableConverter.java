package com.example.demo.converter;

import com.example.demo.entity.JavaTable;
import com.example.demo.entity.KotlinTable;
import com.example.demo.entity.dto.JavaTableAddDTO;
import com.example.demo.entity.dto.JavaTableDTO;
import com.example.demo.entity.dto.JavaTableUpdateDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedSourcePolicy = ReportingPolicy.IGNORE, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface JavaTableConverter {

    JavaTableDTO poToDto(JavaTable javaTable);

    JavaTable dtoToPo(JavaTableDTO javaTableDTO);

    JavaTable convertForAdd(JavaTableAddDTO javaTableAddDTO);

    JavaTable convertForUpdate(JavaTableUpdateDTO table);

    JavaTable kotlinToJava(KotlinTable kotlinTable);

    KotlinTable javaToKotlin(JavaTable javaTable);
}
