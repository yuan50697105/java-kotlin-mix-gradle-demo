package com.example.demo.entity.dto;

import lombok.Data;
import lombok.NonNull;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

/**
 * 商品库存
 */
@Data
public class JavaGoodsStockAddDTO {
    @NonNull
    private Long goodsId;
    @NotBlank
    private String name;
    @Min(1)
    private Integer num;


}
