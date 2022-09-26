package com.example.demo.converter;

import com.example.demo.entity.JavaSystemRole;
import com.example.demo.entity.dto.JavaSystemRoleAddDTO;
import com.example.demo.entity.dto.JavaSystemRoleUpdateDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedSourcePolicy = ReportingPolicy.IGNORE, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface JavaSystemRoleConverter {


    JavaSystemRole convertForAdd(JavaSystemRoleAddDTO javaSystemUserAddDTO);

    JavaSystemRole convertForUpdate(JavaSystemRoleUpdateDTO table);
}
