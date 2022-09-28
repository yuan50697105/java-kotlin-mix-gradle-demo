package com.example.demo.dao.api.impl;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.constants.JavaDaoType;
import com.example.demo.dao.api.JavaSystemPermissionDao;
import com.example.demo.entity.JavaSystemPermission;
import com.example.demo.entity.dto.JavaSystemPermissionWrapper;
import com.example.demo.entity.dto.Pagination;
import com.example.demo.mapper.JavaSystemPermissionDaoMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@Service
public class JavaSystemPermissionPlusDaoImpl extends ServiceImpl<JavaSystemPermissionDaoMapper, JavaSystemPermission> implements JavaSystemPermissionDao, IService<JavaSystemPermission> {
    @Override
    public String getType() {
        return JavaDaoType.PLUS.name();
    }

    @Override
    @Transactional
    public void saveData(JavaSystemPermission javaSystemUser) {
        this.save(javaSystemUser);
    }

    @Override
    @Transactional
    public void updateData(JavaSystemPermission javaSystemUser) {
        this.updateData(javaSystemUser);
    }

    @Override
    public JavaSystemPermission get(Long id) {
        return getById(id);
    }

    @Override
    @Transactional
    public void deleteData(Long[] ids) {
        this.deleteData(Arrays.asList(ids));
    }

    @Override
    @Transactional
    public void deleteData(Collection<Long> ids) {
        removeByIds(ids);
    }

    @Override
    @Transactional
    public void deleteData(Long id, Long... ids) {
        this.deleteData(Lists.asList(id, ids));
    }

    @Override
    public List<JavaSystemPermission> getList(JavaSystemPermissionWrapper javaSystemUser) {
        return lambdaQuery().list();
    }

    @Override
    public List<JavaSystemPermission> getList(JavaSystemPermissionWrapper javaSystemUser, int page, int size) {
        PageHelper.startPage(page, size);
        return getList(javaSystemUser);
    }

    @Override
    public Pagination<JavaSystemPermission> getPage(JavaSystemPermissionWrapper javaSystemUser, int page, int size) {
        PageHelper.startPage(page, size);
        return new Pagination<>(new PageInfo<>(getList(javaSystemUser)));
    }
}
