package com.example.demo.dao.impl;

import com.example.demo.constants.JavaDaoType;
import com.example.demo.dao.JavaSystemPermissionDao;
import com.example.demo.entity.JavaSystemPermission;
import com.example.demo.entity.dto.JavaSystemPermissionWrapper;
import com.example.demo.entity.dto.Pagination;
import com.example.demo.repository.JavaSystemPermissionRepository;
import com.google.common.collect.Lists;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@Service
public class JavaSystemPermissionJpaDaoImpl implements JavaSystemPermissionDao {
    private final JavaSystemPermissionRepository repository;

    public JavaSystemPermissionJpaDaoImpl(JavaSystemPermissionRepository repository) {
        this.repository = repository;
    }

    @Override
    public String getType() {
        return JavaDaoType.JPA.name();
    }

    @Override
    @Transactional
    public void saveData(JavaSystemPermission javaSystemUser) {
        repository.save(javaSystemUser);
    }

    @Override
    public void updateData(JavaSystemPermission javaSystemUser) {
        repository.save(javaSystemUser);
    }

    @Override
    public JavaSystemPermission get(Long id) {
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
    public List<JavaSystemPermission> getList(JavaSystemPermissionWrapper javaSystemUser) {
        return repository.findAll();
    }

    @Override
    public List<JavaSystemPermission> getList(JavaSystemPermissionWrapper javaSystemUser, int page, int size) {
        return getPage(javaSystemUser, page, size).getData();
    }

    @Override
    public Pagination<JavaSystemPermission> getPage(JavaSystemPermissionWrapper javaSystemUser, int page, int size) {
        return new Pagination<>(repository.findAll(PageRequest.of(page <= 1 ? 0 : page - 1, size)));
    }
}
