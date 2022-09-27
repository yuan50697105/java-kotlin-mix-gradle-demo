package com.example.demo.entity.dto;

import lombok.Data;

import java.util.List;

@Data
public class JavaSystemRoleUpdateDTO {
    private Long id;
    private String name;
    private Integer state;
    private List<Long> permissionIds;
}
