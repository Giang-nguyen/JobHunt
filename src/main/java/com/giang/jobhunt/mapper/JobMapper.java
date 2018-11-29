package com.giang.jobhunt.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;

import com.giang.jobhunt.domain.Job;
import com.giang.jobhunt.dto.JobDetail;
import com.giang.jobhunt.dto.JobQuery;
import com.giang.jobhunt.dto.JobResponse;

@Mapper(componentModel="spring")
public interface JobMapper {
	JobResponse jobToResponse(Job job);
	Job responseToJob(JobResponse response);
	JobDetail jobToDetail(Job job);
	Job detailToJob(JobDetail detail);
	JobQuery jobToQuery(Job job);
	Job queryToJob(JobQuery query);
	List<JobResponse> jobsToResponses(List<Job> jobs);
	List<Job> responsesToJobs(List<JobResponse> responses);
	Page<JobResponse> jobToResponse(Page<Job> jobPage);
	Page<Job> responseToJob(Page<JobResponse> responsePage);
}
