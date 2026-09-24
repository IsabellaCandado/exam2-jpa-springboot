package com.example.demo.repository;

import com.example.demo.model.Commit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICommitRepository extends JpaRepository<Commit, Integer> {

    //c4
    List<Commit> findByRepository_ParentRepoIsNotNullAndRepository_ParentRepo_IsTemplateTrueAndRepository_ParentRepo_NameAndMessageContainingIgnoreCaseAndLinesAddedGreaterThan(String parentRepoName, String message, int linesAdded);
}
