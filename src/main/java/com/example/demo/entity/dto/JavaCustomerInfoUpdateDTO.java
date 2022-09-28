package com.example.demo.entity.dto;

import lombok.Data;

@Data
public class JavaCustomerInfoUpdateDTO  {
    private Long id;
    private String code;
    private String name;
    private Integer type;
    private Integer state;

}
