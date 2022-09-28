package com.example.demo.dao.factory;

import com.example.demo.entity.JavaSystemUserDepartment;

import java.util.Collection;
import java.util.List;

public interface JavaSystemUserDepartmentDaoFactory {

    void saveData(String type, JavaSystemUserDepartment data);

    void updateData(String type, JavaSystemUserDepartment data);

    JavaSystemUserDepartment get(String type, Long id);

    void deleteData(String type, Long[] ids);

    void deleteData(String type, Collection<Long> ids);

    void deleteData(String type, Long id, Long... ids);

    void saveData(String type, Long userId, List<Long> departIds);

    void updateData(String type, Long userId, List<Long> departIds);

    void deleteDataByUserIds(String type, Long[] userIds);

    void deleteDataByDepartIds(String type, Long[] departIds);
}
