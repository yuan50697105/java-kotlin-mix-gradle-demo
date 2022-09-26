package com.example.demo.dao.impl;

import com.example.demo.constants.JavaDaoType;
import com.example.demo.dao.JavaSystemUserRoleDao;
import com.example.demo.entity.JavaSystemUserRole;
import com.example.demo.repository.JavaSystemUserRoleRepository;
import com.google.common.collect.Lists;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@Service
public class JavaSystemUserRoleJpaDaoImpl implements JavaSystemUserRoleDao {
    private final JavaSystemUserRoleRepository repository;

    public JavaSystemUserRoleJpaDaoImpl(JavaSystemUserRoleRepository repository) {
        this.repository = repository;
    }

    @Override
    public String getType() {
        return JavaDaoType.JPA.name();
    }

    @Override
    @Transactional
    public void saveData(JavaSystemUserRole javaSystemUser) {
        repository.save(javaSystemUser);
    }

    @Override
    @Transactional
    public void saveData(List<JavaSystemUserRole> javaSystemUser) {
        repository.saveAll(javaSystemUser);
    }

    @Override
    public void updateData(JavaSystemUserRole javaSystemUser) {
        repository.save(javaSystemUser);
    }

    @Override
    public JavaSystemUserRole get(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void deleteData(Long[] ids) {
        this.deleteData(Arrays.asList(ids));
    }

    @Override
    @Transactional
    public void deleteData(Collection<Long> ids) {
        repository.deleteAllById(ids);
    }

    @Override
    public void deleteData(Long id, Long... ids) {
        this.deleteData(Lists.asList(id, ids));
    }

    @Override
    @Transactional
    public void updateData(List<JavaSystemUserRole> javaSystemUserRoles) {
        this.repository.saveAll(javaSystemUserRoles);
    }

    @Override
    @Transactional
    public void deleteDataByUserIds(Long userId, Long[] userIds) {
        this.deleteDataByUserIds(Lists.asList(userId, userIds));
    }

    @Override
    @Transactional
    public void deleteDataByUserIds(Long[] userIds) {
        repository.deleteByUserIdIn(Arrays.asList(userIds));
    }

    @Override
    @Transactional
    public void deleteDataByRoleIds(Long[] roleIds) {
        repository.deleteByRoleIdIn(Arrays.asList(roleIds));
    }

    @Override
    @Transactional
    public void deleteDataByUserIds(List<Long> userIds) {
        repository.deleteByUserIdIn(userIds);
    }

    @Override
    @Transactional
    public void deleteDataByRoleIds(Long roleId, Long[] roleIds) {
        this.deleteDataByRoleIds(Lists.asList(roleId, roleIds));
    }

    @Override
    public void deleteDataByRoleIds(List<Long> roleIds) {
        repository.deleteByRoleIdIn(roleIds);
    }
}
