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
@Table(name = "system_department")
@TableName("system_department")
@FluentMybatis(table = "system_department")
public class JavaSystemDepartment extends RichEntity {
    @Id
    private Long id;
    private String name;
    private Integer state;
    private Long parentId;

    public enum DepartmentState {
        ENABLE(1, "启用"),
        DISABLE(0, "停用"),
        ;

        private final Integer code;
        private final String name;

        DepartmentState(Integer code, String name) {

            this.code = code;
            this.name = name;
        }

        public static DepartmentState getState(String value) {
            for (DepartmentState departmentState : values()) {
                if (departmentState.code.toString().equalsIgnoreCase(value) || departmentState.name.equalsIgnoreCase(value)) {
                    return departmentState;
                }
            }
            throw new IllegalArgumentException(value);
        }

        public static Integer getCode(DepartmentState state) {
            return state.code;
        }

        public Integer getCode() {
            return code;
        }

        public String getName() {
            return name;
        }
    }

}
