package com.example.demo.dao.factory.impl;

import cn.hutool.core.util.ObjUtil;
import com.example.demo.constants.JavaDaoType;
import com.example.demo.dao.api.JavaOrderDetailDao;
import com.example.demo.dao.factory.JavaOrderDetailDaoFactory;
import com.example.demo.entity.JavaOrderDetail;
import com.example.demo.entity.dto.JavaOrderDetailWrapper;
import com.example.demo.entity.dto.Pagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class JavaOrderDetailDaoFactoryImpl implements JavaOrderDetailDaoFactory {
    private final Map<String, JavaOrderDetailDao> daoMap;

    @Autowired
    public JavaOrderDetailDaoFactoryImpl(List<JavaOrderDetailDao> systemUserDaoList) {
        this.daoMap = systemUserDaoList.stream().collect(Collectors.toMap(JavaOrderDetailDao::getType, Function.identity()));
    }

    @Override
    @Transactional
    public void saveData(String type, JavaOrderDetail javaSystemUser) {
        getJavaOrderDetailDao(type).saveData(javaSystemUser);

    }

    @Override
    @Transactional
    public void updateData(String type, JavaOrderDetail javaSystemUser) {
        getJavaOrderDetailDao(type).updateData(javaSystemUser);
    }

    @Override
    public JavaOrderDetail get(String type, Long id) {
        return getJavaOrderDetailDao(type).get(id);
    }

    @Override
    @Transactional
    public void deleteData(String type, Long[] ids) {
        getJavaOrderDetailDao(type).deleteData(ids);
    }

    @Override
    @Transactional
    public void deleteData(String type, Collection<Long> ids) {
        getJavaOrderDetailDao(type).deleteData(ids);
    }

    @Override
    @Transactional
    public void deleteData(String type, Long id, Long... ids) {
        getJavaOrderDetailDao(type).deleteData(ids);
    }

    @Override
    public List<JavaOrderDetail> getList(String type, JavaOrderDetailWrapper javaSystemUser) {
        return getJavaOrderDetailDao(type).getList(javaSystemUser);
    }

    @Override
    public List<JavaOrderDetail> getList(String type, JavaOrderDetailWrapper javaSystemUser, int page, int size) {
        return getJavaOrderDetailDao(type).getList(javaSystemUser, page, size);
    }

    @Override
    public Pagination<JavaOrderDetail> getPage(String type, JavaOrderDetailWrapper javaSystemUser, int page, int size) {
        return getJavaOrderDetailDao(type).getPage(javaSystemUser, page, size);
    }

    private JavaOrderDetailDao getJavaOrderDetailDao(String type) {
        JavaOrderDetailDao javaSystemUserDao = daoMap.get(JavaDaoType.getType(type));
        if (ObjUtil.isNotEmpty(javaSystemUserDao)) {
            return javaSystemUserDao;
        } else {
            throw new IllegalArgumentException(type);
        }
    }
}
