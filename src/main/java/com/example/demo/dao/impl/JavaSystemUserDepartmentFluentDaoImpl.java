package com.example.demo.dao.impl;

import cn.org.atool.fluent.mybatis.base.IBaseDao;
import com.example.demo.constants.JavaDaoType;
import com.example.demo.dao.JavaSystemUserDepartmentDao;
import com.example.demo.dao.base.JavaSystemUserDepartmentBaseDao;
import com.example.demo.entity.JavaSystemUserDepartment;
import com.google.common.collect.Lists;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@Service
public class JavaSystemUserDepartmentFluentDaoImpl extends JavaSystemUserDepartmentBaseDao implements JavaSystemUserDepartmentDao, IBaseDao<JavaSystemUserDepartment> {
    @Override
    public String getType() {
        return JavaDaoType.FLUENT.name();
    }

    @Override
    @Transactional
    public void saveData(JavaSystemUserDepartment javaSystemUser) {
        this.save(javaSystemUser);
    }

    @Override
    @Transactional
    public void updateData(JavaSystemUserDepartment javaSystemUser) {
        this.updateById(javaSystemUser);
    }

    @Override
    public JavaSystemUserDepartment get(Long id) {
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
    public void saveData(Long userId, List<Long> departIds) {
        ArrayList<JavaSystemUserDepartment> list = new ArrayList<>(departIds.size());
        for (Long departId : departIds) {
            list.add(new JavaSystemUserDepartment(userId, departId));
        }
        this.save(list);
    }

    @Override
    @Transactional
    public void updateData(Long userId, List<Long> departIds) {
        deleteBy(query().where.userId().eq(userId).end());
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
        deleteBy(query().where.userId().in(userIds).end());
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
        deleteBy(query().where.departId().in(departIds).end());
    }
}

