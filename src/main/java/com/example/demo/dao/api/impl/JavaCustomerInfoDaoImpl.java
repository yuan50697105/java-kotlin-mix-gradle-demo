package com.example.demo.dao.api.impl;

import cn.org.atool.fluent.mybatis.base.IBaseDao;
import com.example.demo.constants.JavaDaoType;
import com.example.demo.dao.api.JavaCustomerInfoDao;
import com.example.demo.dao.base.JavaCustomerInfoBaseDao;
import com.example.demo.entity.JavaCustomerInfo;
import com.example.demo.entity.dto.JavaCustomerInfoWrapper;
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
public class JavaCustomerInfoDaoImpl extends JavaCustomerInfoBaseDao implements JavaCustomerInfoDao, IBaseDao<JavaCustomerInfo> {
    @Override
    public String getType() {
        return JavaDaoType.FLUENT.name();
    }

    @Override
    @Transactional
    public void saveData(JavaCustomerInfo javaSystemUser) {
        this.save(javaSystemUser);
    }

    @Override
    @Transactional
    public void updateData(JavaCustomerInfo javaSystemUser) {
        this.updateById(javaSystemUser);
    }

    @Override
    public JavaCustomerInfo get(Long id) {
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
    public List<JavaCustomerInfo> getList(JavaCustomerInfoWrapper javaSystemUser) {
        return listEntity(query());
    }

    @Override
    public List<JavaCustomerInfo> getList(JavaCustomerInfoWrapper javaSystemUser, int page, int size) {
        PageHelper.startPage(page, size);
        return getList(javaSystemUser);
    }

    @Override
    public Pagination<JavaCustomerInfo> getPage(JavaCustomerInfoWrapper javaSystemUser, int page, int size) {
        PageHelper.startPage(page, size);
        return new Pagination<JavaCustomerInfo>(new PageInfo<>(getList(javaSystemUser)));
    }
}
