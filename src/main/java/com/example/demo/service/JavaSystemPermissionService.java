package com.example.demo.service;

import cn.hutool.core.lang.tree.Tree;
import com.example.demo.entity.JavaSystemPermission;
import com.example.demo.entity.dto.JavaSystemPermissionAddDTO;
import com.example.demo.entity.dto.JavaSystemPermissionUpdateDTO;
import com.example.demo.entity.dto.JavaSystemPermissionWrapper;
import com.example.demo.entity.dto.Pagination;

import java.util.List;

public interface JavaSystemPermissionService {
    void saveData(String type, JavaSystemPermissionAddDTO table);

    void updateData(String type, JavaSystemPermissionUpdateDTO table);

    void deleteData(String type, Long[] id);

    JavaSystemPermission get(String type, Long id);

    List<JavaSystemPermission> getList(String type, JavaSystemPermissionWrapper wrapper);

    Pagination<JavaSystemPermission> getPage(String type, JavaSystemPermissionWrapper wrapper, int page, int size);

    List<Tree<Long>> getTree(String type, JavaSystemPermissionWrapper wrapper);
}
