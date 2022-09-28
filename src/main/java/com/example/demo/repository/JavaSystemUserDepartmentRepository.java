package com.example.demo.repository;

import com.example.demo.entity.JavaSystemUserDepartment;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface JavaSystemUserDepartmentRepository extends JpaRepositoryImplementation<JavaSystemUserDepartment, Long> {
    @Modifying
    void deleteByUserId(Long userId);

    @Modifying
    void deleteByUserIdIn(Collection<Long> userId);

    @Modifying
    void deleteByDepartId(Long departId);

    @Modifying
    void deleteByDepartIdIn(Collection<Long> departId);
}
