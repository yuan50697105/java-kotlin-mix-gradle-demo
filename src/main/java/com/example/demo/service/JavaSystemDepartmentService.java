package com.example.demo.service;

import cn.hutool.core.lang.tree.Tree;
import com.example.demo.entity.JavaSystemDepartment;
import com.example.demo.entity.dto.JavaSystemDepartmentAddDTO;
import com.example.demo.entity.dto.JavaSystemDepartmentUpdateDTO;
import com.example.demo.entity.dto.JavaSystemDepartmentWrapper;
import com.example.demo.entity.dto.Pagination;

import java.util.List;

public interface JavaSystemDepartmentService {
    void saveData(String type, JavaSystemDepartmentAddDTO table);

    void updateData(String type, JavaSystemDepartmentUpdateDTO table);

    void deleteData(String type, Long[] id);

    JavaSystemDepartment get(String type, Long id);

    List<JavaSystemDepartment> getList(String type, JavaSystemDepartmentWrapper wrapper);

    Pagination<JavaSystemDepartment> getPage(String type, JavaSystemDepartmentWrapper wrapper, int page, int size);

    List<Tree<Long>> getTree(String type, JavaSystemDepartmentWrapper wrapper);
}
