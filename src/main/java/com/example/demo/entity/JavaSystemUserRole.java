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
@Entity
@Table(name = "system_user_role")
@FluentMybatis(table = "system_user_role")
@TableName("system_user_role")
public class JavaSystemUserRole extends RichEntity {
    @Id
    private Long id;
    private Long roleId;
    private Long userId;

    public JavaSystemUserRole() {
    }

    public JavaSystemUserRole(Long userId, Long roleId) {
        this.userId = userId;
        this.roleId = roleId;
    }
}
