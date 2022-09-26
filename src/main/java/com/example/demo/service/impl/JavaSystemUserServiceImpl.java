package com.example.demo.service.impl;

import com.example.demo.converter.JavaSystemUserConverter;
import com.example.demo.dao.factory.JavaSystemUserDaoFactory;
import com.example.demo.dao.factory.JavaSystemUserRoleDaoFactory;
import com.example.demo.entity.JavaSystemUser;
import com.example.demo.entity.dto.JavaSystemUserAddDTO;
import com.example.demo.entity.dto.JavaSystemUserUpdateDTO;
import com.example.demo.entity.dto.JavaSystemUserWrapper;
import com.example.demo.entity.dto.Pagination;
import com.example.demo.service.JavaSystemUserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JavaSystemUserServiceImpl implements JavaSystemUserService {
    private final JavaSystemUserDaoFactory javaSystemUserDaoFactory;
    private final JavaSystemUserRoleDaoFactory javaSystemUserRoleDaoFactory;
    private final JavaSystemUserConverter javaSystemUserConverter;

    public JavaSystemUserServiceImpl(JavaSystemUserDaoFactory javaSystemUserDaoFactory, JavaSystemUserRoleDaoFactory javaSystemUserRoleDaoFactory, JavaSystemUserConverter javaSystemUserConverter) {
        this.javaSystemUserDaoFactory = javaSystemUserDaoFactory;
        this.javaSystemUserRoleDaoFactory = javaSystemUserRoleDaoFactory;
        this.javaSystemUserConverter = javaSystemUserConverter;
    }

    @Override
    public void saveData(String type, JavaSystemUserAddDTO table) {
        JavaSystemUser javaSystemUser = javaSystemUserConverter.convertForAdd(table);
        javaSystemUserDaoFactory.saveData(type, javaSystemUser);
        javaSystemUserRoleDaoFactory.saveData(type, javaSystemUser.getId(), table.getRoleIds());
    }

    @Override
    public void updateData(String type, JavaSystemUserUpdateDTO table) {
        JavaSystemUser javaSystemUser = javaSystemUserConverter.convertForUpdate(table);
        javaSystemUserDaoFactory.updateData(type, javaSystemUser);
        javaSystemUserRoleDaoFactory.updateData(type, table.getId(), table.getRoleIds());
    }

    @Override
    public void deleteData(String type, Long[] id) {
        javaSystemUserDaoFactory.deleteData(type, id);
        javaSystemUserRoleDaoFactory.deleteDataByUserIds(type, id);
    }

    @Override
    public JavaSystemUser get(String type, Long id) {
        return javaSystemUserDaoFactory.get(type, id);
    }

    @Override
    public List<JavaSystemUser> getList(String type, JavaSystemUserWrapper wrapper) {
        return javaSystemUserDaoFactory.getList(type, wrapper);
    }

    @Override
    public Pagination<JavaSystemUser> getPage(String type, JavaSystemUserWrapper wrapper, int page, int size) {
        return javaSystemUserDaoFactory.getPage(type, wrapper, page, size);
    }
}
