package com.example.demo.converter;

import com.example.demo.entity.JavaSystemPermission;
import com.example.demo.entity.dto.JavaSystemPermissionAddDTO;
import com.example.demo.entity.dto.JavaSystemPermissionUpdateDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedSourcePolicy = ReportingPolicy.IGNORE, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface JavaSystemPermissionConverter {


    JavaSystemPermission convertForAdd(JavaSystemPermissionAddDTO javaSystemUserAddDTO);

    JavaSystemPermission convertForUpdate(JavaSystemPermissionUpdateDTO table);
}
