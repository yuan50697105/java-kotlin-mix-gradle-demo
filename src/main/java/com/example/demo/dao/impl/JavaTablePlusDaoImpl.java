package com.example.demo.dao.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.PageDTO;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.dao.JavaTableDao;
import com.example.demo.entity.JavaTable;
import com.example.demo.entity.dto.Pagination;
import com.example.demo.entity.dto.JavaTableWrapper;
import com.example.demo.mapper.JavaTableDaoMapper;
import com.example.demo.service.JavaTableDaoFactory;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

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

    @Override
    @Transactional
    public void updateData(JavaTable javaTable) {
        this.updateById(javaTable);
    }

    @Override
    public JavaTable get(Long id) {
        return getById(id);
    }

    @Override
    public List<JavaTable> getList(JavaTableWrapper wrapper) {
        return lambdaQuery().list();
    }

    @Override
    public Pagination<JavaTable> getPage(JavaTableWrapper wrapper, int page, int size) {
        return new Pagination<JavaTable>(lambdaQuery().page(new PageDTO<>(page, size)));
    }

    @Override
    @Transactional
    public void deleteData(Long[] id) {
        this.removeByIds(Arrays.asList(id));
    }
}
