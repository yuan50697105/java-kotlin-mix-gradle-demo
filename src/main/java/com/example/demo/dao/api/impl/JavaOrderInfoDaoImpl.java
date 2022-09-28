package com.example.demo.dao.api.impl;

import cn.org.atool.fluent.mybatis.base.IBaseDao;
import com.example.demo.constants.JavaDaoType;
import com.example.demo.dao.api.JavaOrderInfoDao;
import com.example.demo.dao.base.JavaOrderInfoBaseDao;
import com.example.demo.entity.JavaOrderInfo;
import com.example.demo.entity.dto.JavaOrderInfoWrapper;
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
public class JavaOrderInfoDaoImpl extends JavaOrderInfoBaseDao implements JavaOrderInfoDao, IBaseDao<JavaOrderInfo> {
    @Override
    public String getType() {
        return JavaDaoType.FLUENT.name();
    }

    @Override
    @Transactional
    public void saveData(JavaOrderInfo javaSystemUser) {
        this.save(javaSystemUser);
    }

    @Override
    @Transactional
    public void updateData(JavaOrderInfo javaSystemUser) {
        this.updateById(javaSystemUser);
    }

    @Override
    public JavaOrderInfo get(Long id) {
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
    public List<JavaOrderInfo> getList(JavaOrderInfoWrapper javaSystemUser) {
        return listEntity(query());
    }

    @Override
    public List<JavaOrderInfo> getList(JavaOrderInfoWrapper javaSystemUser, int page, int size) {
        PageHelper.startPage(page, size);
        return getList(javaSystemUser);
    }

    @Override
    public Pagination<JavaOrderInfo> getPage(JavaOrderInfoWrapper javaSystemUser, int page, int size) {
        PageHelper.startPage(page, size);
        return new Pagination<JavaOrderInfo>(new PageInfo<>(getList(javaSystemUser)));
    }
}
