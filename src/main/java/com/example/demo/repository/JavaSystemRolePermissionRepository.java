package com.example.demo.repository;

import com.example.demo.entity.JavaSystemRolePermission;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface JavaSystemRolePermissionRepository extends JpaRepositoryImplementation<JavaSystemRolePermission, Long> {
    @Modifying
    void deleteByRoleIdIn(Collection<Long> roleId);

    @Modifying
    void deleteByRoleId(Long roleId);

    @Modifying
    void deleteByPermissionIdIn(Collection<Long> permissionId);

    @Modifying
    void deleteByPermissionId(Long permissionId);
}
