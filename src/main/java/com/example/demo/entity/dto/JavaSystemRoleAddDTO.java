package com.example.demo.entity.dto;

import lombok.Data;

import java.util.List;

@Data
public class JavaSystemRoleAddDTO {
    private String name;
    private List<Long> permissionIds;
}
