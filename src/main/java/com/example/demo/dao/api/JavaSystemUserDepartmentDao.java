package com.example.demo.dao.api;

import com.example.demo.entity.JavaSystemUserDepartment;

import java.util.Collection;
import java.util.List;

public interface JavaSystemUserDepartmentDao {
    String getType();

    void saveData(JavaSystemUserDepartment javaSystemRole);

    void updateData(JavaSystemUserDepartment javaSystemRole);

    JavaSystemUserDepartment get(Long id);

    void deleteData(Long[] ids);

    void deleteData(Collection<Long> ids);

    void deleteData(Long id, Long... ids);

    void saveData(Long userId, List<Long> departIds);

    void updateData(Long userId, List<Long> departIds);

    void deleteDataByUserIds(Long[] userIds);

    void deleteDataByUserIds(Long userId, Long[] userIds);

    void deleteDataByUserIds(List<Long> userIds);

    void deleteDataByDepartIds(Long[] departIds);

    void deleteDataByDepartIds(Long departId, Long[] departIds);

    void deleteDataByDepartIds(List<Long> departIds);

}
