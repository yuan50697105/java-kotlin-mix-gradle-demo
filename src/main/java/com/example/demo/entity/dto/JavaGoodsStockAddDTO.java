package com.example.demo.entity.dto;

import lombok.Data;

/**
 * 商品库存
 */
@Data
public class JavaGoodsStockAddDTO {
    private Long goodsId;
    private String name;
    private Integer num;


}
