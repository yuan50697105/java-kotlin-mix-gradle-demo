package com.example.demo.entity.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class JavaSystemUserAddDTO implements Serializable {
    private String username;
    private String password;
    private String name;
    private List<Long> roleIds;
}
