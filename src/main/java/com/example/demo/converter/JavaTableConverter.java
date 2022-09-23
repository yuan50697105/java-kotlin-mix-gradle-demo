package com.example.demo.converter;

import com.example.demo.entity.JavaTable;
import org.mapstruct.Mapper;
import com.example.demo.entity.dto.JavaTableDTO;
@Mapper(componentModel = "spring")
public interface JavaTableConverter {
    JavaTableDTO poToDto(JavaTable javaTable);

    JavaTable dtoToPo(JavaTableDTO javaTableDTO);
}
