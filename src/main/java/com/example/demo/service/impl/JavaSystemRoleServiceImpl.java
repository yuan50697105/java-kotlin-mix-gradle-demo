package com.example.demo.service.impl;

import com.example.demo.converter.JavaSystemRoleConverter;
import com.example.demo.dao.factory.JavaSystemRoleDaoFactory;
import com.example.demo.dao.factory.JavaSystemRolePermissionDaoFactory;
import com.example.demo.dao.factory.JavaSystemUserRoleDaoFactory;
import com.example.demo.entity.JavaSystemRole;
import com.example.demo.entity.dto.JavaSystemRoleAddDTO;
import com.example.demo.entity.dto.JavaSystemRoleUpdateDTO;
import com.example.demo.entity.dto.JavaSystemRoleWrapper;
import com.example.demo.entity.dto.Pagination;
import com.example.demo.service.JavaSystemRoleService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JavaSystemRoleServiceImpl implements JavaSystemRoleService {
    private final JavaSystemRoleDaoFactory daoFactory;
    private final JavaSystemUserRoleDaoFactory systemUserRoleDaoFactory;
    private final JavaSystemRolePermissionDaoFactory systemRolePermissionDaoFactory;
    private final JavaSystemRoleConverter converter;

    public JavaSystemRoleServiceImpl(JavaSystemRoleDaoFactory daoFactory, JavaSystemUserRoleDaoFactory systemUserRoleDaoFactory, JavaSystemRolePermissionDaoFactory systemRolePermissionDaoFactory, JavaSystemRoleConverter converter) {
        this.daoFactory = daoFactory;
        this.systemUserRoleDaoFactory = systemUserRoleDaoFactory;
        this.systemRolePermissionDaoFactory = systemRolePermissionDaoFactory;
        this.converter = converter;
    }

    @Override
    public void saveData(String type, JavaSystemRoleAddDTO table) {
        JavaSystemRole javaSystemUser = converter.convertForAdd(table);
        daoFactory.saveData(type, javaSystemUser);
        systemRolePermissionDaoFactory.saveData(type, javaSystemUser.getId(), table.getPermissionIds());
    }

    @Override
    public void updateData(String type, JavaSystemRoleUpdateDTO table) {
        JavaSystemRole javaSystemUser = converter.convertForUpdate(table);
        daoFactory.updateData(type, javaSystemUser);
        systemRolePermissionDaoFactory.updateData(type, table.getId(), table.getPermissionIds());
    }

    @Override
    public void deleteData(String type, Long[] id) {
        daoFactory.deleteData(type, id);
        systemUserRoleDaoFactory.deleteDataByRoleIds(type, id);
        systemRolePermissionDaoFactory.deleteDataByRoleIds(type, id);
    }

    @Override
    public JavaSystemRole get(String type, Long id) {
        return daoFactory.get(type, id);
    }

    @Override
    public List<JavaSystemRole> getList(String type, JavaSystemRoleWrapper wrapper) {
        return daoFactory.getList(type, wrapper);
    }

    @Override
    public Pagination<JavaSystemRole> getPage(String type, JavaSystemRoleWrapper wrapper, int page, int size) {
        return daoFactory.getPage(type, wrapper, page, size);
    }
}
