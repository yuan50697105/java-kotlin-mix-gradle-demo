package com.example.demo.entity.dto;

import com.example.demo.entity.JavaOrderInfo;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
public class JavaOrderInfoDTO extends JavaOrderInfo {
    private List<JavaOrderGoodsDTO> items;

    public BigDecimal getItemsTotalPrice() {
        return items.stream().map(JavaOrderGoodsDTO::getTotalPrice).reduce(BigDecimal::add).orElse(BigDecimal.ZERO);
    }

    @Data
    public static class JavaOrderGoodsDTO {
        private Long goodsId;
        private Integer num = 1;
        private BigDecimal price = BigDecimal.ZERO;

        public BigDecimal getTotalPrice() {
            return BigDecimal.valueOf(num).multiply(price);
        }

        public Integer getDecreaseNum() {
            return -1 * num;
        }
    }
}
