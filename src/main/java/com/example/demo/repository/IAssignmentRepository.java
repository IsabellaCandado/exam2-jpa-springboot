package com.example.demo.repository;

import com.example.demo.model.Assignment;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAssignmentRepository extends JpaRepository<Assignment, Integer> {
    //c5
    List<Assignment> findByClassroom_Teacher_UsernameAndRepositories_PullRequests_Reviewer_UsernameAndRepositories_PullRequests_Status(String teacherUsername, String prReviewerUsername, String prStatus);
}
