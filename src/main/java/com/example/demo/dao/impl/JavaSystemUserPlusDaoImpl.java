package com.example.demo.dao.impl;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.constants.DaoType;
import com.example.demo.dao.JavaSystemUserDao;
import com.example.demo.entity.JavaSystemUser;
import com.example.demo.entity.dto.Pagination;
import com.example.demo.mapper.JavaSystemUserDaoMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@Service
public class JavaSystemUserPlusDaoImpl extends ServiceImpl<JavaSystemUserDaoMapper, JavaSystemUser> implements JavaSystemUserDao, IService<JavaSystemUser> {
    @Override
    public String getType() {
        return DaoType.PLUS.name();
    }

    @Override
    @Transactional
    public void saveData(JavaSystemUser javaSystemUser) {
        this.save(javaSystemUser);
    }

    @Override
    @Transactional
    public void updateData(JavaSystemUser javaSystemUser) {
        this.updateData(javaSystemUser);
    }

    @Override
    public JavaSystemUser get(Long id) {
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
    public List<JavaSystemUser> getList(JavaSystemUser javaSystemUser) {
        return lambdaQuery().list();
    }

    @Override
    public List<JavaSystemUser> getList(JavaSystemUser javaSystemUser, int page, int size) {
        PageHelper.startPage(page, size);
        return getList(javaSystemUser);
    }

    @Override
    public Pagination<JavaSystemUser> getPage(JavaSystemUser javaSystemUser, int page, int size) {
        PageHelper.startPage(page, size);
        return new Pagination<>(new PageInfo<>(getList(javaSystemUser)));
    }
}
