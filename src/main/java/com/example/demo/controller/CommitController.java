package com.example.demo.controller;

import com.example.demo.model.Commit;
import com.example.demo.repository.ICommitRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/commits")
@RequiredArgsConstructor
public class CommitController {

    private final ICommitRepository commitRepository;

    @GetMapping
    public List<Commit> findAllCommits() {
        return commitRepository.findAll();
    }

    //http://localhost:3001/compunet2-2026/commits/c4
    @GetMapping("/c4")
    public List<Commit> c4() {
        return commitRepository.findByRepository_ParentRepoIsNotNullAndRepository_ParentRepo_IsTemplateTrueAndRepository_ParentRepo_NameAndMessageContainingIgnoreCaseAndLinesAddedGreaterThan(
                "template-jpa-exam",
                "fix",
                50
        );
    }
}
