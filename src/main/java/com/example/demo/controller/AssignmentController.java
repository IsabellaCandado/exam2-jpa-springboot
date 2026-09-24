package com.example.demo.controller;

import com.example.demo.model.Assignment;
import com.example.demo.repository.IAssignmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/assignments")
@RequiredArgsConstructor
public class AssignmentController {

    private final IAssignmentRepository assignmentRepository;

    @GetMapping
    public List<Assignment> findAllAssignments() {
        return assignmentRepository.findAll();
    }

    //http://localhost:3001/compunet2-2026/assignments/c5
    @GetMapping("/c5")
    public List<Assignment> c5() {
        return assignmentRepository.findByClassroom_Teacher_UsernameAndRepositories_PullRequests_Reviewer_UsernameAndRepositories_PullRequests_Status(
                "krodriguez",
                "jvalencia",
                "MERGED"
        );
    }
}
