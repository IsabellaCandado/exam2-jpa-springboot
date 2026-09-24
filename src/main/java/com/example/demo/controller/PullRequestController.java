package com.example.demo.controller;

import com.example.demo.model.PullRequest;
import com.example.demo.repository.IPullRequestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/pull-requests")
public class PullRequestController {

    @Autowired
    private IPullRequestRepository pullRequestRepository;

    @GetMapping
    public List<PullRequest> findAllPullRequests() {
        return pullRequestRepository.findAll();
    }

    //http://localhost:3001/compunet2-2026/pull-requests/c1
    @GetMapping("/c1")
    public List<PullRequest> c1() {
        return pullRequestRepository.findByRepository_Assignment_Classroom_NameAndStatusOrderByCreatedAtDesc(
                "Computacion en Internet II - Grupo 1",
                "OPEN"
        );
    }

    //http://localhost:3001/compunet2-2026/pull-requests/c3
    @GetMapping("/c3")
    public List<PullRequest> c3() {
        return pullRequestRepository.findByReviewer_RoleAndAuthor_UsernameAndRepository_Assignment_Classroom_Semester(
                "TA",
                "cjimenez",
                "2026-02"
        );
    }
}
