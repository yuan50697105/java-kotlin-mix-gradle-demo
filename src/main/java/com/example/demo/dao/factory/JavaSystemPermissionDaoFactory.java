package com.example.demo.dao.factory;

import cn.hutool.core.lang.tree.Tree;
import com.example.demo.entity.JavaSystemPermission;
import com.example.demo.entity.dto.JavaSystemPermissionWrapper;
import com.example.demo.entity.dto.Pagination;

import java.util.Collection;
import java.util.List;

public interface JavaSystemPermissionDaoFactory {

    void saveData(String type, JavaSystemPermission data);

    void updateData(String type, JavaSystemPermission data);

    JavaSystemPermission get(String type, Long id);

    void deleteData(String type, Long[] ids);

    void deleteData(String type, Collection<Long> ids);

    void deleteData(String type, Long id, Long... ids);

    List<JavaSystemPermission> getList(String type, JavaSystemPermissionWrapper wrapper);

    List<JavaSystemPermission> getList(String type, JavaSystemPermissionWrapper wrapper, int page, int size);

    Pagination<JavaSystemPermission> getPage(String type, JavaSystemPermissionWrapper wrapper, int page, int size);

    List<Tree<Long>> getTree(String type, JavaSystemPermissionWrapper wrapper);
}
