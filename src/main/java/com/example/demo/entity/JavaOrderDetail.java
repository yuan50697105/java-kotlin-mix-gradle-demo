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
@Table(name = "order_detail")
@TableName("order_detail")
@FluentMybatis(table = "order_detail")
public class JavaOrderDetail extends RichEntity {
    @Id
    private Long id;
    private Long orderId;
    private String orderCode;
    private Long goodsId;
    private BigDecimal price;
    private Integer num;
}
