package com.example.demo.entity.dto;

import lombok.Data;

import javax.persistence.Id;

@Data
public class JavaSystemPermissionUpdateDTO {
    @Id
    private Long id;
    private String name;
    private Integer type;

}
