package com.example.demo.dao.impl;

import cn.org.atool.fluent.mybatis.base.IBaseDao;
import com.example.demo.constants.JavaDaoType;
import com.example.demo.dao.JavaSystemDepartmentDao;
import com.example.demo.dao.base.JavaSystemDepartmentBaseDao;
import com.example.demo.entity.JavaSystemDepartment;
import com.example.demo.entity.dto.JavaSystemDepartmentWrapper;
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
public class JavaSystemDepartmentFluentDaoImpl extends JavaSystemDepartmentBaseDao implements JavaSystemDepartmentDao, IBaseDao<JavaSystemDepartment> {
    @Override
    public String getType() {
        return JavaDaoType.FLUENT.name();
    }

    @Override
    @Transactional
    public void saveData(JavaSystemDepartment javaSystemUser) {
        this.save(javaSystemUser);
    }

    @Override
    @Transactional
    public void updateData(JavaSystemDepartment javaSystemUser) {
        this.updateById(javaSystemUser);
    }

    @Override
    public JavaSystemDepartment get(Long id) {
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
    public List<JavaSystemDepartment> getList(JavaSystemDepartmentWrapper javaSystemUser) {
        return listEntity(query());
    }

    @Override
    public List<JavaSystemDepartment> getList(JavaSystemDepartmentWrapper javaSystemUser, int page, int size) {
        PageHelper.startPage(page, size);
        return getList(javaSystemUser);
    }

    @Override
    public Pagination<JavaSystemDepartment> getPage(JavaSystemDepartmentWrapper javaSystemUser, int page, int size) {
        PageHelper.startPage(page, size);
        return new Pagination<JavaSystemDepartment>(new PageInfo<>(getList(javaSystemUser)));
    }
}
