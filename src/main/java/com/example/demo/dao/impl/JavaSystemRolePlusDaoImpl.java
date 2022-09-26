package com.example.demo.dao.impl;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.constants.JavaDaoType;
import com.example.demo.dao.JavaSystemRoleDao;
import com.example.demo.entity.JavaSystemRole;
import com.example.demo.entity.dto.JavaSystemRoleWrapper;
import com.example.demo.entity.dto.Pagination;
import com.example.demo.mapper.JavaSystemRoleDaoMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@Service
public class JavaSystemRolePlusDaoImpl extends ServiceImpl<JavaSystemRoleDaoMapper, JavaSystemRole> implements JavaSystemRoleDao, IService<JavaSystemRole> {
    @Override
    public String getType() {
        return JavaDaoType.PLUS.name();
    }

    @Override
    @Transactional
    public void saveData(JavaSystemRole javaSystemUser) {
        this.save(javaSystemUser);
    }

    @Override
    @Transactional
    public void updateData(JavaSystemRole javaSystemUser) {
        this.updateData(javaSystemUser);
    }

    @Override
    public JavaSystemRole get(Long id) {
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
    public List<JavaSystemRole> getList(JavaSystemRoleWrapper javaSystemUser) {
        return lambdaQuery().list();
    }

    @Override
    public List<JavaSystemRole> getList(JavaSystemRoleWrapper javaSystemUser, int page, int size) {
        PageHelper.startPage(page, size);
        return getList(javaSystemUser);
    }

    @Override
    public Pagination<JavaSystemRole> getPage(JavaSystemRoleWrapper javaSystemUser, int page, int size) {
        PageHelper.startPage(page, size);
        return new Pagination<>(new PageInfo<>(getList(javaSystemUser)));
    }
}
