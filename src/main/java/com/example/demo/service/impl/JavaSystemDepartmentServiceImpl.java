package com.example.demo.service.impl;

import com.example.demo.converter.JavaSystemDepartmentConverter;
import com.example.demo.dao.factory.JavaSystemDepartmentDaoFactory;
import com.example.demo.dao.factory.JavaSystemUserDepartmentDaoFactory;
import com.example.demo.entity.JavaSystemDepartment;
import com.example.demo.entity.dto.JavaSystemDepartmentAddDTO;
import com.example.demo.entity.dto.JavaSystemDepartmentUpdateDTO;
import com.example.demo.entity.dto.JavaSystemDepartmentWrapper;
import com.example.demo.entity.dto.Pagination;
import com.example.demo.service.JavaSystemDepartmentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JavaSystemDepartmentServiceImpl implements JavaSystemDepartmentService {
    private final JavaSystemDepartmentDaoFactory daoFactory;
    private final JavaSystemUserDepartmentDaoFactory systemUserDepartmentDaoFactory;
    private final JavaSystemDepartmentConverter converter;

    public JavaSystemDepartmentServiceImpl(JavaSystemDepartmentDaoFactory daoFactory, JavaSystemUserDepartmentDaoFactory systemUserDepartmentDaoFactory, JavaSystemDepartmentConverter converter) {
        this.daoFactory = daoFactory;
        this.systemUserDepartmentDaoFactory = systemUserDepartmentDaoFactory;
        this.converter = converter;
    }

    @Override
    public void saveData(String type, JavaSystemDepartmentAddDTO table) {
        JavaSystemDepartment javaSystemUser = converter.convertForAdd(table);
        daoFactory.saveData(type, javaSystemUser);
    }

    @Override
    public void updateData(String type, JavaSystemDepartmentUpdateDTO table) {
        JavaSystemDepartment javaSystemUser = converter.convertForUpdate(table);
        daoFactory.updateData(type, javaSystemUser);
    }

    @Override
    public void deleteData(String type, Long[] id) {
        daoFactory.deleteData(type, id);
        systemUserDepartmentDaoFactory.deleteDataByDepartIds(type, id);
    }

    @Override
    public JavaSystemDepartment get(String type, Long id) {
        return daoFactory.get(type, id);
    }

    @Override
    public List<JavaSystemDepartment> getList(String type, JavaSystemDepartmentWrapper wrapper) {
        return daoFactory.getList(type, wrapper);
    }

    @Override
    public Pagination<JavaSystemDepartment> getPage(String type, JavaSystemDepartmentWrapper wrapper, int page, int size) {
        return daoFactory.getPage(type, wrapper, page, size);
    }
}
