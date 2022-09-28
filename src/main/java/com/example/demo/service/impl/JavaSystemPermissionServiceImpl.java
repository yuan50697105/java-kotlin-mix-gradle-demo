package com.example.demo.service.impl;

import cn.hutool.core.lang.tree.Tree;
import com.example.demo.converter.JavaSystemPermissionConverter;
import com.example.demo.dao.factory.JavaSystemPermissionDaoFactory;
import com.example.demo.dao.factory.JavaSystemRolePermissionDaoFactory;
import com.example.demo.entity.JavaSystemPermission;
import com.example.demo.entity.dto.JavaSystemPermissionAddDTO;
import com.example.demo.entity.dto.JavaSystemPermissionUpdateDTO;
import com.example.demo.entity.dto.JavaSystemPermissionWrapper;
import com.example.demo.entity.dto.Pagination;
import com.example.demo.service.JavaSystemPermissionService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JavaSystemPermissionServiceImpl implements JavaSystemPermissionService {
    private final JavaSystemPermissionDaoFactory daoFactory;
    private final JavaSystemRolePermissionDaoFactory systemRolePermissionDaoFactory;
    private final JavaSystemPermissionConverter converter;

    public JavaSystemPermissionServiceImpl(JavaSystemPermissionDaoFactory daoFactory, JavaSystemRolePermissionDaoFactory systemRolePermissionDaoFactory, JavaSystemPermissionConverter converter) {
        this.daoFactory = daoFactory;
        this.systemRolePermissionDaoFactory = systemRolePermissionDaoFactory;
        this.converter = converter;
    }

    @Override
    public void saveData(String type, JavaSystemPermissionAddDTO table) {
        JavaSystemPermission javaSystemUser = converter.convertForAdd(table);
        daoFactory.saveData(type, javaSystemUser);
    }

    @Override
    public void updateData(String type, JavaSystemPermissionUpdateDTO table) {
        JavaSystemPermission javaSystemUser = converter.convertForUpdate(table);
        daoFactory.updateData(type, javaSystemUser);
    }

    @Override
    public void deleteData(String type, Long[] id) {
        daoFactory.deleteData(type, id);
        systemRolePermissionDaoFactory.deleteDataByPermissionIds(type, id);
    }

    @Override
    public JavaSystemPermission get(String type, Long id) {
        return daoFactory.get(type, id);
    }

    @Override
    public List<JavaSystemPermission> getList(String type, JavaSystemPermissionWrapper wrapper) {
        return daoFactory.getList(type, wrapper);
    }

    @Override
    public Pagination<JavaSystemPermission> getPage(String type, JavaSystemPermissionWrapper wrapper, int page, int size) {
        return daoFactory.getPage(type, wrapper, page, size);
    }

    @Override
    public List<Tree<Long>> getTree(String type, JavaSystemPermissionWrapper wrapper) {
        return daoFactory.getTree(type, wrapper);
    }
}
