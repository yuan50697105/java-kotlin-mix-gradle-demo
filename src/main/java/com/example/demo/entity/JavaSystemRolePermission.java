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
@Table(name = "system_role_permission")
@TableName("system_role_permission")
@FluentMybatis(table = "system_role_permission")
public class JavaSystemRolePermission extends RichEntity {
    @Id
    private Long id;
    private Long roleId;
    private Long permissionId;

    public JavaSystemRolePermission() {
    }

    public JavaSystemRolePermission(Long roleId, Long permissionId) {
        this.roleId = roleId;
        this.permissionId = permissionId;
    }
}
