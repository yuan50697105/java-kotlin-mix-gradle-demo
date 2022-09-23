package com.example.demo.entity;

import cn.org.atool.fluent.mybatis.annotation.FluentMybatis;
import cn.org.atool.fluent.mybatis.base.RichEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@FluentMybatis
public class JavaTable extends RichEntity {
    private Long id;

    public JavaTable() {
        String a = KotlinTable.a;
        KotlinTable kotlinTable = new KotlinTable();
        kotlinTable.setId(111L);

    }
}
