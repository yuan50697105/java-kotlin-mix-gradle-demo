package com.example.demo.repository;

import com.example.demo.entity.JavaSystemPermission;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

@Repository
public interface JavaSystemPermissionRepository extends JpaRepositoryImplementation<JavaSystemPermission, Long> {
}
