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
@Table(name = "system_user_department")
@TableName("system_user_department")
@FluentMybatis(table = "system_user_department")
public class JavaSystemUserDepartment extends RichEntity {
    @Id
    private Long id;
    private Long userId;
    private Long departId;

    public JavaSystemUserDepartment() {
    }

    public JavaSystemUserDepartment(Long userId, Long departId) {

        this.userId = userId;
        this.departId = departId;
    }
}
