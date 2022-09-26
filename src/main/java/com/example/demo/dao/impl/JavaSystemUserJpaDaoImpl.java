package com.example.demo.dao.impl;

import com.example.demo.constants.KotlinDaoType;
import com.example.demo.dao.JavaSystemUserDao;
import com.example.demo.entity.JavaSystemUser;
import com.example.demo.entity.dto.JavaSystemUserWrapper;
import com.example.demo.entity.dto.Pagination;
import com.example.demo.repository.JavaSystemUserRepository;
import com.google.common.collect.Lists;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@Service
public class JavaSystemUserJpaDaoImpl implements JavaSystemUserDao {
    private final JavaSystemUserRepository javaSystemUserRepository;

    public JavaSystemUserJpaDaoImpl(JavaSystemUserRepository javaSystemUserRepository) {
        this.javaSystemUserRepository = javaSystemUserRepository;
    }

    @Override
    public String getType() {
        return KotlinDaoType.JPA.name();
    }

    @Override
    @Transactional
    public void saveData(JavaSystemUser javaSystemUser) {
        javaSystemUserRepository.save(javaSystemUser);
    }

    @Override
    public void updateData(JavaSystemUser javaSystemUser) {
        javaSystemUserRepository.save(javaSystemUser);
    }

    @Override
    public JavaSystemUser get(Long id) {
        return javaSystemUserRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void deleteData(Long[] ids) {
        this.deleteData(Arrays.asList(ids));
    }

    @Override
    @Transactional
    public void deleteData(Collection<Long> ids) {
        javaSystemUserRepository.deleteAllById(ids);
    }

    @Override
    public void deleteData(Long id, Long... ids) {
        this.deleteData(Lists.asList(id, ids));
    }

    @Override
    public List<JavaSystemUser> getList(JavaSystemUserWrapper javaSystemUser) {
        return javaSystemUserRepository.findAll();
    }

    @Override
    public List<JavaSystemUser> getList(JavaSystemUserWrapper javaSystemUser, int page, int size) {
        return getPage(javaSystemUser, page, size).getData();
    }

    @Override
    public Pagination<JavaSystemUser> getPage(JavaSystemUserWrapper javaSystemUser, int page, int size) {
        return new Pagination<>(javaSystemUserRepository.findAll(PageRequest.of(page <= 1 ? 0 : page - 1, size)));
    }
}
