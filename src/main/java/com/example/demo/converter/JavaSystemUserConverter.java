package com.example.demo.converter;

import com.example.demo.entity.JavaSystemUser;
import com.example.demo.entity.dto.JavaSystemUserAddDTO;
import com.example.demo.entity.dto.JavaSystemUserDTO;
import com.example.demo.entity.dto.JavaSystemUserUpdateDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedSourcePolicy = ReportingPolicy.IGNORE, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface JavaSystemUserConverter {
    JavaSystemUserDTO poToDto(JavaSystemUser javaSystemUser);

    JavaSystemUser dtoToPo(JavaSystemUserDTO javaSystemUserDTO);

    JavaSystemUser convertForAdd(JavaSystemUserAddDTO javaSystemUserAddDTO);

    JavaSystemUser convertForUpdate(JavaSystemUserUpdateDTO table);
}
