package com.example.demo.dao.api.impl;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.constants.JavaDaoType;
import com.example.demo.dao.api.JavaSystemUserDepartmentDao;
import com.example.demo.entity.JavaSystemUserDepartment;
import com.example.demo.mapper.JavaSystemUserDepartmentDaoMapper;
import com.google.common.collect.Lists;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@Service
public class JavaSystemUserDepartmentPlusDaoImpl extends ServiceImpl<JavaSystemUserDepartmentDaoMapper, JavaSystemUserDepartment> implements JavaSystemUserDepartmentDao, IService<JavaSystemUserDepartment> {
    @Override
    public String getType() {
        return JavaDaoType.PLUS.name();
    }

    @Override
    @Transactional
    public void saveData(JavaSystemUserDepartment javaSystemUser) {
        this.save(javaSystemUser);
    }

    @Override
    @Transactional
    public void updateData(JavaSystemUserDepartment javaSystemUser) {
        this.updateData(javaSystemUser);
    }

    @Override
    public JavaSystemUserDepartment get(Long id) {
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
    public void saveData(Long userId, List<Long> departIds) {
        ArrayList<JavaSystemUserDepartment> entityList = new ArrayList<>(departIds.size());
        for (Long departId : departIds) {
            entityList.add(new JavaSystemUserDepartment(userId, departId));
        }
        this.saveBatch(entityList);
    }

    @Override
    @Transactional
    public void updateData(Long userId, List<Long> departIds) {
        lambdaUpdate().eq(JavaSystemUserDepartment::getUserId, userId).remove();
        saveData(userId, departIds);
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
        lambdaUpdate().in(JavaSystemUserDepartment::getUserId, userIds).remove();
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
        lambdaUpdate().in(JavaSystemUserDepartment::getDepartId, departIds).remove();
    }
}
