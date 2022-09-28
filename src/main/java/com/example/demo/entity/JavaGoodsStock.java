package com.example.demo.entity;

import cn.org.atool.fluent.mybatis.annotation.FluentMybatis;
import cn.org.atool.fluent.mybatis.base.RichEntity;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 商品库存
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "goods_stock")
@TableName("goods_stock")
@FluentMybatis(table = "goods_stock")
public class JavaGoodsStock extends RichEntity {
    @Id
    private Long id;
    private Long goodsId;
    private String name;
    private Integer num;


}
