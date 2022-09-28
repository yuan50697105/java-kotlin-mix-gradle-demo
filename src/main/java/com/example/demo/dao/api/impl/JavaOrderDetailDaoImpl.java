package com.example.demo.dao.api.impl;

import cn.org.atool.fluent.mybatis.base.IBaseDao;
import com.example.demo.constants.JavaDaoType;
import com.example.demo.dao.api.JavaOrderDetailDao;
import com.example.demo.dao.base.JavaOrderDetailBaseDao;
import com.example.demo.entity.JavaOrderDetail;
import com.example.demo.entity.dto.JavaOrderDetailWrapper;
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
public class JavaOrderDetailDaoImpl extends JavaOrderDetailBaseDao implements JavaOrderDetailDao, IBaseDao<JavaOrderDetail> {
    @Override
    public String getType() {
        return JavaDaoType.FLUENT.name();
    }

    @Override
    @Transactional
    public void saveData(JavaOrderDetail javaSystemUser) {
        this.save(javaSystemUser);
    }

    @Override
    @Transactional
    public void updateData(JavaOrderDetail javaSystemUser) {
        this.updateById(javaSystemUser);
    }

    @Override
    public JavaOrderDetail get(Long id) {
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
    public List<JavaOrderDetail> getList(JavaOrderDetailWrapper javaSystemUser) {
        return listEntity(query());
    }

    @Override
    public List<JavaOrderDetail> getList(JavaOrderDetailWrapper javaSystemUser, int page, int size) {
        PageHelper.startPage(page, size);
        return getList(javaSystemUser);
    }

    @Override
    public Pagination<JavaOrderDetail> getPage(JavaOrderDetailWrapper javaSystemUser, int page, int size) {
        PageHelper.startPage(page, size);
        return new Pagination<JavaOrderDetail>(new PageInfo<>(getList(javaSystemUser)));
    }
}
