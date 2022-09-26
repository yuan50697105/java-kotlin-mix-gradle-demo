package com.example.demo.dao.impl;

import cn.org.atool.fluent.mybatis.base.IBaseDao;
import com.example.demo.constants.DaoType;
import com.example.demo.dao.JavaSystemUserDao;
import com.example.demo.dao.base.JavaSystemUserBaseDao;
import com.example.demo.entity.JavaSystemUser;
import com.example.demo.entity.dto.JavaSystemUserWrapper;
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
public class JavaSystemUserFluentDaoImpl extends JavaSystemUserBaseDao implements JavaSystemUserDao, IBaseDao<JavaSystemUser> {
    @Override
    public String getType() {
        return DaoType.FLUENT.name();
    }

    @Override
    @Transactional
    public void saveData(JavaSystemUser javaSystemUser) {
        this.save(javaSystemUser);
    }

    @Override
    @Transactional
    public void updateData(JavaSystemUser javaSystemUser) {
        this.updateById(javaSystemUser);
    }

    @Override
    public JavaSystemUser get(Long id) {
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
    public List<JavaSystemUser> getList(JavaSystemUserWrapper javaSystemUser) {
        return listEntity(query());
    }

    @Override
    public List<JavaSystemUser> getList(JavaSystemUserWrapper javaSystemUser, int page, int size) {
        PageHelper.startPage(page, size);
        return getList(javaSystemUser);
    }

    @Override
    public Pagination<JavaSystemUser> getPage(JavaSystemUserWrapper javaSystemUser, int page, int size) {
        PageHelper.startPage(page, size);
        return new Pagination<JavaSystemUser>(new PageInfo<>(getList(javaSystemUser)));
    }
}
