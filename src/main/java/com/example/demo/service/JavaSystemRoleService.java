package com.example.demo.service;

import com.example.demo.entity.JavaSystemRole;
import com.example.demo.entity.dto.JavaSystemRoleAddDTO;
import com.example.demo.entity.dto.JavaSystemRoleUpdateDTO;
import com.example.demo.entity.dto.JavaSystemRoleWrapper;
import com.example.demo.entity.dto.Pagination;

import java.util.List;

public interface JavaSystemRoleService {
    void saveData(String type, JavaSystemRoleAddDTO table);

    void updateData(String type, JavaSystemRoleUpdateDTO table);

    void deleteData(String type, Long[] id);

    JavaSystemRole get(String type, Long id);

    List<JavaSystemRole> getList(String type, JavaSystemRoleWrapper wrapper);

    Pagination<JavaSystemRole> getPage(String type, JavaSystemRoleWrapper wrapper, int page, int size);
}
