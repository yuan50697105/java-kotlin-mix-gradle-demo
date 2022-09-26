package com.example.demo.dao.impl;

import cn.org.atool.fluent.mybatis.base.IBaseDao;
import com.example.demo.constants.JavaDaoType;
import com.example.demo.dao.JavaSystemRoleDao;
import com.example.demo.dao.base.JavaSystemRoleBaseDao;
import com.example.demo.entity.JavaSystemRole;
import com.example.demo.entity.dto.JavaSystemRoleWrapper;
import com.example.demo.entity.dto.Pagination;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@Service
public class JavaSystemRoleFluentDaoImpl extends JavaSystemRoleBaseDao implements JavaSystemRoleDao, IBaseDao<JavaSystemRole> {
    @Override
    public String getType() {
        return JavaDaoType.FLUENT.name();
    }

    @Override
    @Transactional
    public void saveData(JavaSystemRole javaSystemUser) {
        this.save(javaSystemUser);
    }

    @Override
    @Transactional
    public void updateData(JavaSystemRole javaSystemUser) {
        this.updateById(javaSystemUser);
    }

    @Override
    public JavaSystemRole get(Long id) {
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
    public List<JavaSystemRole> getList(JavaSystemRoleWrapper javaSystemUser) {
        return listEntity(query());
    }

    @Override
    public List<JavaSystemRole> getList(JavaSystemRoleWrapper javaSystemUser, int page, int size) {
        PageHelper.startPage(page, size);
        return getList(javaSystemUser);
    }

    @Override
    public Pagination<JavaSystemRole> getPage(JavaSystemRoleWrapper javaSystemUser, int page, int size) {
        PageHelper.startPage(page, size);
        return new Pagination<JavaSystemRole>(new PageInfo<>(getList(javaSystemUser)));
    }
}
