package com.example.demo.dao.impl;

import cn.org.atool.fluent.mybatis.base.IBaseDao;
import com.example.demo.dao.JavaTableDao;
import com.example.demo.dao.base.JavaTableBaseDao;
import com.example.demo.entity.JavaTable;
import com.example.demo.service.JavaTableDaoFactory;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class JavaTableFluentDaoImpl extends JavaTableBaseDao implements IBaseDao<JavaTable>, JavaTableDao {
    @Override
    public String getType() {
        return JavaTableDaoFactory.DaoType.FLUENT.name();
    }

    @Override
    @Transactional
    public void saveData(JavaTable data) {
        this.save(data);
    }
}
