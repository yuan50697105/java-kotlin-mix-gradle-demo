package com.example.demo.converter;

import com.example.demo.entity.JavaSystemUser;
import com.example.demo.entity.dto.JavaSystemUserAddDTO;
import com.example.demo.entity.dto.JavaSystemUserUpdateDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedSourcePolicy = ReportingPolicy.IGNORE, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface JavaSystemUserConverter {

    @Mapping(target = "state", ignore = true)
    @Mapping(target = "id", ignore = true)
    JavaSystemUser convertForAdd(JavaSystemUserAddDTO javaSystemUserAddDTO);

    @Mapping(target = "password", ignore = true)
    JavaSystemUser convertForUpdate(JavaSystemUserUpdateDTO table);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "password", ignore = true)
    void copyForUpdate(@MappingTarget JavaSystemUser javaSystemUser, JavaSystemUserUpdateDTO table);
}
