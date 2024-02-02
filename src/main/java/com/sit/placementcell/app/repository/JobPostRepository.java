package com.sit.placementcell.app.repository;

import com.sit.placementcell.app.entity.JobPost;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobPostRepository extends JpaRepository<JobPost,Integer> {
}
