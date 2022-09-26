package com.example.demo.entity.dto;

import com.example.demo.entity.JavaSystemUser;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@EqualsAndHashCode(callSuper = true)
@Data
public class JavaSystemUserDTO extends JavaSystemUser implements Serializable {

}
