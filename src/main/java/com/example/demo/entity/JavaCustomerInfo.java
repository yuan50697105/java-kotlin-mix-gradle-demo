package com.example.demo.entity;

import cn.org.atool.fluent.mybatis.annotation.FluentMybatis;
import cn.org.atool.fluent.mybatis.base.RichEntity;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "customer_info")
@TableName("customer_info")
@FluentMybatis(table = "customer_info")
public class JavaCustomerInfo extends RichEntity {
    @Id
    private Long id;
    private String code;
    private String name;
    private Integer type;
    private Integer state;

    public enum CustomerType {
        COMMONS(0, "普通客户"),
        ;

        private final Integer code;
        private final String value;

        CustomerType(Integer code, String value) {

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

    public enum CustomerState {
        NO_CONTRACT(0, "未签约"),
        CONTRACT(0, "已签约"),
        CONTRACT_TIME_OUT(0, "签约已失效"),
        ;

        private final Integer code;
        private final String value;

        CustomerState(Integer code, String value) {

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

}
