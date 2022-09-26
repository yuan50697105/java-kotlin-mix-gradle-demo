package com.example.demo.service;

import com.example.demo.entity.JavaSystemUser;
import com.example.demo.entity.dto.JavaSystemUserAddDTO;
import com.example.demo.entity.dto.JavaSystemUserUpdateDTO;
import com.example.demo.entity.dto.JavaSystemUserWrapper;
import com.example.demo.entity.dto.Pagination;

import java.util.List;

public interface JavaSystemUserService {
    void saveData(String type, JavaSystemUserAddDTO table);

    void updateData(String type, JavaSystemUserUpdateDTO table);

    void deleteData(String type, Long[] id);

    JavaSystemUser get(String type, Long id);

    List<JavaSystemUser> getList(String type, JavaSystemUserWrapper wrapper);

    Pagination<JavaSystemUser> getPage(String type, JavaSystemUserWrapper wrapper, int page, int size);
}
