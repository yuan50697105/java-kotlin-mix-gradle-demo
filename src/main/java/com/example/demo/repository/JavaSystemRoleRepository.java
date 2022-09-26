package com.example.demo.repository;

import com.example.demo.entity.JavaSystemRole;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

@Repository
public interface JavaSystemRoleRepository extends JpaRepositoryImplementation<JavaSystemRole, Long> {
}
