package com.example.demo.converter;

import com.example.demo.entity.JavaSystemDepartment;
import com.example.demo.entity.dto.JavaSystemDepartmentAddDTO;
import com.example.demo.entity.dto.JavaSystemDepartmentUpdateDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedSourcePolicy = ReportingPolicy.IGNORE, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface JavaSystemDepartmentConverter {


    JavaSystemDepartment convertForAdd(JavaSystemDepartmentAddDTO javaSystemUserAddDTO);

    JavaSystemDepartment convertForUpdate(JavaSystemDepartmentUpdateDTO table);
}
