package com.example.demo.entity.dto;

import com.example.demo.entity.JavaSystemPermission;
import lombok.Data;

@Data
public class JavaSystemPermissionAddDTO {
    private String name;
    private Integer type = JavaSystemPermission.PermissionType.MENU.getCode();
    private Long parentId = 0L;
    private Integer weight = 0;


}
