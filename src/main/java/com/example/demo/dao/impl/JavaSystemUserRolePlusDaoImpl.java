package com.example.demo.dao.impl;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.constants.JavaDaoType;
import com.example.demo.dao.JavaSystemUserRoleDao;
import com.example.demo.entity.JavaSystemUserRole;
import com.example.demo.mapper.JavaSystemUserRoleDaoMapper;
import com.google.common.collect.Lists;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@Service
public class JavaSystemUserRolePlusDaoImpl extends ServiceImpl<JavaSystemUserRoleDaoMapper, JavaSystemUserRole> implements JavaSystemUserRoleDao, IService<JavaSystemUserRole> {
    @Override
    public String getType() {
        return JavaDaoType.PLUS.name();
    }

    @Override
    @Transactional
    public void saveData(JavaSystemUserRole javaSystemUser) {
        this.save(javaSystemUser);
    }

    @Override
    @Transactional
    public void saveData(List<JavaSystemUserRole> javaSystemUser) {
        this.saveBatch(javaSystemUser);
    }

    @Override
    @Transactional
    public void updateData(JavaSystemUserRole javaSystemUser) {
        this.updateById(javaSystemUser);
    }

    @Override
    @Transactional
    public void updateData(List<JavaSystemUserRole> javaSystemUserRoles) {
        this.updateBatchById(javaSystemUserRoles);
    }

    @Override
    public JavaSystemUserRole get(Long id) {
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
    @Transactional
    public void deleteDataByUserIds(Long userId, Long[] userIds) {
        this.deleteDataByUserIds(Lists.asList(userId, userIds));
    }

    @Override
    @Transactional
    public void deleteDataByUserIds(Long[] userIds) {
        this.deleteDataByUserIds(Arrays.asList(userIds));
    }

    @Override
    @Transactional
    public void deleteDataByUserIds(List<Long> userIds) {
        lambdaUpdate().in(JavaSystemUserRole::getRoleId, userIds).remove();
    }

    @Override
    @Transactional
    public void deleteDataByRoleIds(Long[] roleIds) {
        this.deleteDataByRoleIds(Arrays.asList(roleIds));

    }

    @Override
    @Transactional
    public void deleteDataByRoleIds(Long roleId, Long[] roleIds) {
        this.deleteDataByRoleIds(Lists.asList(roleId, roleIds));
    }

    @Override
    @Transactional
    public void deleteDataByRoleIds(List<Long> roleIds) {
        lambdaUpdate().in(JavaSystemUserRole::getRoleId, roleIds).remove();
    }

}
