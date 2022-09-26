package com.example.demo.dao.factory.impl;

import cn.hutool.core.util.ObjUtil;
import com.example.demo.constants.JavaDaoType;
import com.example.demo.dao.JavaSystemRoleDao;
import com.example.demo.dao.factory.JavaSystemRoleDaoFactory;
import com.example.demo.entity.JavaSystemRole;
import com.example.demo.entity.dto.JavaSystemRoleWrapper;
import com.example.demo.entity.dto.Pagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class JavaSystemRoleDaoFactoryImpl implements JavaSystemRoleDaoFactory {
    private final Map<String, JavaSystemRoleDao> daoMap;

    @Autowired
    public JavaSystemRoleDaoFactoryImpl(List<JavaSystemRoleDao> systemUserDaoList) {
        this.daoMap = systemUserDaoList.stream().collect(Collectors.toMap(JavaSystemRoleDao::getType, Function.identity()));
    }

    @Override
    public void saveData(String type, JavaSystemRole javaSystemUser) {
        getJavaSystemRoleDao(type).saveData(javaSystemUser);

    }

    @Override
    public void updateData(String type, JavaSystemRole javaSystemUser) {
        getJavaSystemRoleDao(type).updateData(javaSystemUser);
    }

    @Override
    public JavaSystemRole get(String type, Long id) {
        return getJavaSystemRoleDao(type).get(id);
    }

    @Override
    public void deleteData(String type, Long[] ids) {
        getJavaSystemRoleDao(type).deleteData(ids);
    }

    @Override
    public void deleteData(String type, Collection<Long> ids) {
        getJavaSystemRoleDao(type).deleteData(ids);
    }

    @Override
    public void deleteData(String type, Long id, Long... ids) {
        getJavaSystemRoleDao(type).deleteData(ids);
    }

    @Override
    public List<JavaSystemRole> getList(String type, JavaSystemRoleWrapper javaSystemUser) {
        return getJavaSystemRoleDao(type).getList(javaSystemUser);
    }

    @Override
    public List<JavaSystemRole> getList(String type, JavaSystemRoleWrapper javaSystemUser, int page, int size) {
        return getJavaSystemRoleDao(type).getList(javaSystemUser, page, size);
    }

    @Override
    public Pagination<JavaSystemRole> getPage(String type, JavaSystemRoleWrapper javaSystemUser, int page, int size) {
        return getJavaSystemRoleDao(type).getPage(javaSystemUser, page, size);
    }

    private JavaSystemRoleDao getJavaSystemRoleDao(String type) {
        JavaSystemRoleDao javaSystemUserDao = daoMap.get(JavaDaoType.getType(type));
        if (ObjUtil.isNotEmpty(javaSystemUserDao)) {
            return javaSystemUserDao;
        } else {
            throw new IllegalArgumentException(type);
        }
    }
}
