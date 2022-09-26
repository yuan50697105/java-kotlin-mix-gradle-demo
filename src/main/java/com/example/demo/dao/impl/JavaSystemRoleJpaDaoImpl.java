package com.example.demo.dao.impl;

import com.example.demo.constants.JavaDaoType;
import com.example.demo.dao.JavaSystemRoleDao;
import com.example.demo.entity.JavaSystemRole;
import com.example.demo.entity.dto.JavaSystemRoleWrapper;
import com.example.demo.entity.dto.Pagination;
import com.example.demo.repository.JavaSystemRoleRepository;
import com.google.common.collect.Lists;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@Service
public class JavaSystemRoleJpaDaoImpl implements JavaSystemRoleDao {
    private final JavaSystemRoleRepository repository;

    public JavaSystemRoleJpaDaoImpl(JavaSystemRoleRepository repository) {
        this.repository = repository;
    }

    @Override
    public String getType() {
        return JavaDaoType.JPA.name();
    }

    @Override
    @Transactional
    public void saveData(JavaSystemRole javaSystemUser) {
        repository.save(javaSystemUser);
    }

    @Override
    public void updateData(JavaSystemRole javaSystemUser) {
        repository.save(javaSystemUser);
    }

    @Override
    public JavaSystemRole get(Long id) {
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
    public List<JavaSystemRole> getList(JavaSystemRoleWrapper javaSystemUser) {
        return repository.findAll();
    }

    @Override
    public List<JavaSystemRole> getList(JavaSystemRoleWrapper javaSystemUser, int page, int size) {
        return getPage(javaSystemUser, page, size).getData();
    }

    @Override
    public Pagination<JavaSystemRole> getPage(JavaSystemRoleWrapper javaSystemUser, int page, int size) {
        return new Pagination<>(repository.findAll(PageRequest.of(page <= 1 ? 0 : page - 1, size)));
    }
}
