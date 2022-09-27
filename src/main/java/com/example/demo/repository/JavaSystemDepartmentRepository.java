package com.example.demo.repository;

import com.example.demo.entity.JavaSystemDepartment;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

@Repository
public interface JavaSystemDepartmentRepository extends JpaRepositoryImplementation<JavaSystemDepartment, Long> {
}
