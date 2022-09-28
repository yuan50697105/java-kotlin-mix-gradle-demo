package com.example.demo.dao.api.impl;

import cn.org.atool.fluent.mybatis.base.IBaseDao;
import com.example.demo.constants.JavaDaoType;
import com.example.demo.dao.api.JavaGoodsStockDao;
import com.example.demo.dao.base.JavaGoodsStockBaseDao;
import com.example.demo.entity.JavaGoodsStock;
import com.example.demo.entity.dto.JavaGoodsStockWrapper;
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
public class JavaGoodsStockFluentDaoImpl extends JavaGoodsStockBaseDao implements JavaGoodsStockDao, IBaseDao<JavaGoodsStock> {
    @Override
    public String getType() {
        return JavaDaoType.FLUENT.name();
    }

    @Override
    @Transactional
    public void saveData(JavaGoodsStock javaSystemUser) {
        this.save(javaSystemUser);
    }

    @Override
    @Transactional
    public void updateData(JavaGoodsStock javaSystemUser) {
        this.updateById(javaSystemUser);
    }

    @Override
    public JavaGoodsStock get(Long id) {
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
    public List<JavaGoodsStock> getList(JavaGoodsStockWrapper javaSystemUser) {
        return listEntity(query());
    }

    @Override
    public List<JavaGoodsStock> getList(JavaGoodsStockWrapper javaSystemUser, int page, int size) {
        PageHelper.startPage(page, size);
        return getList(javaSystemUser);
    }

    @Override
    public Pagination<JavaGoodsStock> getPage(JavaGoodsStockWrapper javaSystemUser, int page, int size) {
        PageHelper.startPage(page, size);
        return new Pagination<JavaGoodsStock>(new PageInfo<>(getList(javaSystemUser)));
    }
}
