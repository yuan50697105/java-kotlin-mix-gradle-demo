package com.example.demo.dao.impl;

import cn.org.atool.fluent.mybatis.base.IBaseDao;
import com.example.demo.constants.JavaDaoType;
import com.example.demo.dao.JavaSystemUserRoleDao;
import com.example.demo.dao.base.JavaSystemUserRoleBaseDao;
import com.example.demo.entity.JavaSystemUserRole;
import com.google.common.collect.Lists;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@Service
public class JavaSystemUserRoleFluentDaoImpl extends JavaSystemUserRoleBaseDao implements JavaSystemUserRoleDao, IBaseDao<JavaSystemUserRole> {
    @Override
    public String getType() {
        return JavaDaoType.FLUENT.name();
    }

    @Override
    @Transactional
    public void saveData(JavaSystemUserRole javaSystemUser) {
        this.save(javaSystemUser);
    }

    @Override
    public void saveData(List<JavaSystemUserRole> javaSystemUser) {
        this.save(javaSystemUser);
    }

    @Override
    @Transactional
    public void updateData(JavaSystemUserRole javaSystemUser) {
        this.updateById(javaSystemUser);
    }

    @Override
    public JavaSystemUserRole get(Long id) {
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
    @Transactional
    public void updateData(List<JavaSystemUserRole> javaSystemUserRoles) {
        this.updateEntityByIds(javaSystemUserRoles);
    }

    @Override
    public void deleteDataByUserIds(Long userId, Long[] userIds) {
        this.deleteDataByUserIds(Lists.asList(userId, userIds));
    }

    @Override
    @Transactional
    public void deleteDataByUserIds(Long[] userIds) {
        this.deleteBy(query().where.userId().in(userIds).end());
    }

    @Override
    @Transactional
    public void deleteDataByUserIds(List<Long> userIds) {
        this.deleteBy(query().where.roleId().in(userIds).end());
    }

    @Override
    @Transactional
    public void deleteDataByRoleIds(Long roleId, Long[] roleIds) {
        this.deleteDataByRoleIds(Lists.asList(roleId, roleIds));
    }

    @Override
    @Transactional
    public void deleteDataByRoleIds(Long[] roleIds) {
        this.deleteBy(query().where.roleId().in(roleIds).end());
    }

    @Override
    @Transactional
    public void deleteDataByRoleIds(List<Long> roleIds) {
        this.deleteBy(query().where.roleId().in(roleIds).end());
    }

}
