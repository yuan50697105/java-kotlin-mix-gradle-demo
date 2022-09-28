package com.example.demo.entity.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class JavaOrderInfoAddDTO {
    private String code;
    private Long customerId;
    private BigDecimal totalPrice;
    private Integer type;
    private Integer state;
}
