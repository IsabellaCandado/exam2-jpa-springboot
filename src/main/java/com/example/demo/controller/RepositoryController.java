package com.example.demo.controller;

import com.example.demo.model.Repository;
import com.example.demo.repository.IRepositoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;

@RestController
@RequestMapping("/repositories")
@RequiredArgsConstructor
public class RepositoryController {

    private final IRepositoryRepository repositoryRepository;

    @GetMapping
    public List<Repository> findAllRepositories() {
        return repositoryRepository.findAll();
    }

    //http://localhost:3001/compunet2-2026/repositories/c2
    @GetMapping("/c2")
    public List<Repository> c2() {
        return repositoryRepository.findByParentRepoIsNotNullAndAssignment_Classroom_Teacher_EmailAndAssignment_DeadlineBefore(
                "krodriguez@icesi.edu.co",
                Timestamp.from(Instant.now())
        );
    }
}
