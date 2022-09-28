package com.example.demo.dao.impl;

import com.example.demo.constants.JavaDaoType;
import com.example.demo.dao.JavaSystemUserDepartmentDao;
import com.example.demo.entity.JavaSystemUserDepartment;
import com.example.demo.repository.JavaSystemUserDepartmentRepository;
import com.google.common.collect.Lists;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@Service
public class JavaSystemUserDepartmentJpaDaoImpl implements JavaSystemUserDepartmentDao {
    private final JavaSystemUserDepartmentRepository repository;

    public JavaSystemUserDepartmentJpaDaoImpl(JavaSystemUserDepartmentRepository repository) {
        this.repository = repository;
    }

    @Override
    public String getType() {
        return JavaDaoType.JPA.name();
    }

    @Override
    @Transactional
    public void saveData(JavaSystemUserDepartment javaSystemUser) {
        repository.save(javaSystemUser);
    }

    @Override
    public void updateData(JavaSystemUserDepartment javaSystemUser) {
        repository.save(javaSystemUser);
    }

    @Override
    public JavaSystemUserDepartment get(Long id) {
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
    public void saveData(Long userId, List<Long> departIds) {
        ArrayList<JavaSystemUserDepartment> entities = new ArrayList<>(departIds.size());
        for (Long departId : departIds) {
            entities.add(new JavaSystemUserDepartment(userId, departId));
        }
        this.repository.saveAll(entities);
    }

    @Override
    @Transactional
    public void updateData(Long userId, List<Long> departIds) {
        this.repository.deleteByUserId(userId);
        this.saveData(userId, departIds);
    }

    @Override
    @Transactional
    public void deleteDataByUserIds(Long[] userIds) {
        this.deleteDataByUserIds(Arrays.asList(userIds));
    }

    @Override
    @Transactional
    public void deleteDataByUserIds(Long userId, Long[] userIds) {
        this.deleteDataByUserIds(Lists.asList(userId, userIds));
    }

    @Override
    @Transactional
    public void deleteDataByUserIds(List<Long> userIds) {
        this.repository.deleteByUserIdIn(userIds);
    }

    @Override
    @Transactional
    public void deleteDataByDepartIds(Long[] departIds) {
        deleteDataByDepartIds(Arrays.asList(departIds));
    }

    @Override
    @Transactional
    public void deleteDataByDepartIds(Long departId, Long[] departIds) {
        deleteDataByDepartIds(Lists.asList(departId, departIds));
    }

    @Override
    @Transactional
    public void deleteDataByDepartIds(List<Long> departIds) {
        repository.deleteByDepartIdIn(departIds);
    }
}
