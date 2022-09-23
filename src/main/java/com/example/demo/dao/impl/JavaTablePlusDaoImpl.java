package com.example.demo.dao.impl;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.dao.JavaTableDao;
import com.example.demo.entity.JavaTable;
import com.example.demo.mapper.JavaTableDaoMapper;
import com.example.demo.service.JavaTableDaoFactory;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class JavaTablePlusDaoImpl extends ServiceImpl<JavaTableDaoMapper, JavaTable> implements JavaTableDao, IService<JavaTable> {
    @Override
    public String getType() {
        return JavaTableDaoFactory.DaoType.PLUS.name();
    }

    @Override
    @Transactional
    public void saveData(JavaTable data) {
        this.save(data);
    }
}
