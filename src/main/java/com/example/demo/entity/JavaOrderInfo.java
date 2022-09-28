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
@Table(name = "order_info")
@TableName("order_info")
@FluentMybatis(table = "order_info")
public class JavaOrderInfo extends RichEntity {
    @Id
    private Long id;
    private String code;
    private Long customerId;
    private BigDecimal totalPrice;
    private Integer type;
    private Integer state;

    public enum OrderState {
        CREATED(0, "已创建"),
        CANCEL(1, "已取消"),
        TIMEOUT(2, "已超时"),
        PAID(3, "已付款"),
        TRANSFORM(4, "运输中"),
        COMPLETED(5, "已完成"),
        ;

        private final Integer code;
        private final String value;

        OrderState(Integer code, String value) {

            this.code = code;
            this.value = value;
        }

        public Integer getCode() {
            return code;
        }

        public String getValue() {
            return value;
        }
    }

    public enum OrderType {
        COMMONS(0, "普通单", "没有详情"),
        DETAIL(1, "详情单", "有明细"),
        VIRTUAL(2, "虚拟服务", "无需配送，直接完成"),
        ;

        private final Integer code;
        private final String value;
        private final String desc;

        OrderType(Integer code, String value, String desc) {

            this.code = code;
            this.value = value;
            this.desc = desc;
        }

        public Integer getCode() {
            return code;
        }

        public String getValue() {
            return value;
        }

        public String getDesc() {
            return desc;
        }
    }

}
