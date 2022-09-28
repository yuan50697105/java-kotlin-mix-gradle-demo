package com.example.demo.entity;

import cn.org.atool.fluent.mybatis.annotation.FluentMybatis;
import cn.org.atool.fluent.mybatis.base.RichEntity;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "goods_info")
@TableName("goods_info")
@FluentMybatis(table = "goods_info")
public class JavaGoodsInfo extends RichEntity {
    @Id
    private Long id;
    private String code;
    private String name;
    private BigDecimal price;
    private Integer state;
    private Integer num;
    public enum GoodsState {
        CREATED(0, "已创建"),
        ONLINE(1, "已上架"),
        OFFLINE(2, "已下架"),
        ;

        private final Integer code;
        private final String value;

        GoodsState(Integer code, String value) {

            this.code = code;
            this.value = value;
        }

        public static GoodsState get(String value) {
            for (GoodsState goodsState : values()) {
                if (goodsState.code.toString().equalsIgnoreCase(value) || goodsState.value.equalsIgnoreCase(value)) {
                    return goodsState;
                }
            }
            throw new IllegalArgumentException(value);
        }

        public Integer getCode() {
            return code;
        }

        public String getValue() {
            return value;
        }
    }

}
