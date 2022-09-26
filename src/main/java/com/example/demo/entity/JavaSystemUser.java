package com.example.demo.entity;

import cn.org.atool.fluent.mybatis.annotation.FluentMybatis;
import cn.org.atool.fluent.mybatis.base.RichEntity;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@EqualsAndHashCode(callSuper = true)
@Data
@FluentMybatis(table = "system_user")
@TableName("system_user")
@Entity
@Table(name = "system_user")
public class JavaSystemUser extends RichEntity {
    @Id
    private Long id;
    private String username;
    private String password;
    private String name;
    private Integer state;
}
