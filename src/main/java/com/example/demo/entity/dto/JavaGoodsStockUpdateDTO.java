package com.example.demo.entity.dto;

import lombok.Data;

/**
 * 商品库存
 */
@Data
public class JavaGoodsStockUpdateDTO {
    private Long id;
    private String goodsId;
    private String name;
    private Integer num;


}
