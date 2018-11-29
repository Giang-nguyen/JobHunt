package com.giang.jobhunt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import com.giang.jobhunt.domain.Job;

@Repository
public interface JobRepository extends JpaRepository<Job, Long>, QuerydslPredicateExecutor<Job> {
}
