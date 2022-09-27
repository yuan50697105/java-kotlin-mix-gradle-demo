package com.example.demo.dao.impl;

import cn.org.atool.fluent.mybatis.base.IBaseDao;
import com.example.demo.constants.JavaDaoType;
import com.example.demo.dao.JavaSystemPermissionDao;
import com.example.demo.dao.base.JavaSystemPermissionBaseDao;
import com.example.demo.entity.JavaSystemPermission;
import com.example.demo.entity.dto.JavaSystemPermissionWrapper;
import com.example.demo.entity.dto.Pagination;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@Service
public class JavaSystemPermissionFluentDaoImpl extends JavaSystemPermissionBaseDao implements JavaSystemPermissionDao, IBaseDao<JavaSystemPermission> {
    @Override
    public String getType() {
        return JavaDaoType.FLUENT.name();
    }

    @Override
    @Transactional
    public void saveData(JavaSystemPermission javaSystemUser) {
        this.save(javaSystemUser);
    }

    @Override
    @Transactional
    public void updateData(JavaSystemPermission javaSystemUser) {
        this.updateById(javaSystemUser);
    }

    @Override
    public JavaSystemPermission get(Long id) {
        return this.selectById(id);
    }

    @Override
    @Transactional
    public void deleteData(Long[] ids) {
        this.deleteByIds(Arrays.asList(ids));
    }

    @Override
    @Transactional
    public void deleteData(Collection<Long> ids) {
        this.deleteByIds(ids);
    }

    @Override
    @Transactional
    public void deleteData(Long id, Long... ids) {
        this.deleteData(Lists.asList(id, ids));
    }

    @Override
    public List<JavaSystemPermission> getList(JavaSystemPermissionWrapper javaSystemUser) {
        return listEntity(query());
    }

    @Override
    public List<JavaSystemPermission> getList(JavaSystemPermissionWrapper javaSystemUser, int page, int size) {
        PageHelper.startPage(page, size);
        return getList(javaSystemUser);
    }

    @Override
    public Pagination<JavaSystemPermission> getPage(JavaSystemPermissionWrapper javaSystemUser, int page, int size) {
        PageHelper.startPage(page, size);
        return new Pagination<JavaSystemPermission>(new PageInfo<>(getList(javaSystemUser)));
    }
}
