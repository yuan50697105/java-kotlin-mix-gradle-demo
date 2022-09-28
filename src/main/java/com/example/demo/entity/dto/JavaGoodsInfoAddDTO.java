package com.example.demo.entity.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class JavaGoodsInfoAddDTO {
    private String code;
    private String name;
    private BigDecimal price;
    private Integer state;
}
