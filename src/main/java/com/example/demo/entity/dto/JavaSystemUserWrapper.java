package com.example.demo.entity.dto;

import com.example.demo.entity.JavaSystemUser;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class JavaSystemUserWrapper extends JavaSystemUser implements Serializable {
    private List<Long> ids;
}
