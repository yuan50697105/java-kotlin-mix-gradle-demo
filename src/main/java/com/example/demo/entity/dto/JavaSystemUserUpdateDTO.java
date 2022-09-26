package com.example.demo.entity.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class JavaSystemUserUpdateDTO implements Serializable {
    private Long id;
    private String username;
    private String name;
    private Integer state;
    private List<Long> roleIds;
}
