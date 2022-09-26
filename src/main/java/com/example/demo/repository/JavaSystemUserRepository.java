package com.example.demo.repository;

import com.example.demo.entity.JavaSystemUser;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

@Repository
public interface JavaSystemUserRepository extends JpaRepositoryImplementation<JavaSystemUser, Long> {
}
