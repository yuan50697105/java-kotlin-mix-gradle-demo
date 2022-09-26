package com.example.demo.repository;

import com.example.demo.entity.JavaSystemUserRole;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface JavaSystemUserRoleRepository extends JpaRepositoryImplementation<JavaSystemUserRole, Long> {

    @Modifying
    void deleteByUserIdIn(Collection<Long> userId);

    @Modifying
    void deleteByRoleIdIn(Collection<Long> roleId);
}
