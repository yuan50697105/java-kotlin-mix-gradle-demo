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
@Table(name = "system_permission")
@FluentMybatis(table = "system_permission")
@TableName("system_permission")
public class JavaSystemPermission extends RichEntity {
    @Id
    private Long id;
    private String name;
    private Integer type;

    public enum PermissionType {
        MENU(1, "菜单");

        private final Integer code;
        private final String name;

        PermissionType(Integer code, String name) {

            this.code = code;
            this.name = name;
        }

        public int getCode() {
            return code;
        }

        public String getName() {
            return name;
        }

        public PermissionType get(String value) {
            for (PermissionType permissionType : values()) {
                if (permissionType.code.toString().equalsIgnoreCase(value) || permissionType.name.equalsIgnoreCase(value)) {
                    return permissionType;
                }
            }
            throw new IllegalArgumentException(value);
        }

        public Integer getCode(PermissionType permissionType) {
            return permissionType.code;
        }
    }

}
