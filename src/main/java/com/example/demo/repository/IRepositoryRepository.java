package com.example.demo.repository;

import com.example.demo.model.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Timestamp;
import java.util.List;

@org.springframework.stereotype.Repository
public interface IRepositoryRepository extends JpaRepository<Repository, Integer> {

    //c2
    List<Repository> findByParentRepoIsNotNullAndAssignment_Classroom_Teacher_EmailAndAssignment_DeadlineBefore(String teacherEmail, Timestamp deadline);
}
