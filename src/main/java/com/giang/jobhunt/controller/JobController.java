package com.giang.jobhunt.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.giang.jobhunt.domain.Job;
import com.giang.jobhunt.dto.JobDetail;
import com.giang.jobhunt.dto.JobQuery;
import com.giang.jobhunt.dto.JobResponse;
import com.giang.jobhunt.mapper.JobMapper;
import com.giang.jobhunt.service.JobService;

@RestController
@RequestMapping("/")
public class JobController {

	private final JobService service;
	private final JobMapper mapper;

	@Autowired
	protected JobController(JobService service, JobMapper mapper) {
		this.service = service;
		this.mapper = mapper;
	}

	@GetMapping("/details/{id}")
	JobDetail viewJob(@PathVariable Long id) {
		return mapper.jobToDetail(service.find(id));
	}

	@PostMapping("/postJob")
	void postJob(@RequestBody JobDetail job) {
		service.save(mapper.detailToJob(job));
	}

	@PutMapping("/edit")
	void editJob(@RequestBody JobDetail job) {
		service.update(mapper.detailToJob(job));
	}

	@GetMapping("/delete/{id}")
	void deleteJob(@PathVariable Long id) {
		service.delete(id);
	}

	@GetMapping("/search")
	List<JobResponse> search(@RequestBody JobQuery query) {
		Job job = mapper.queryToJob(query);
		return mapper.jobsToResponses(service.find(job));
	}

	@GetMapping("/search")
	Page<JobResponse> search(@RequestParam int page, @RequestParam int size, @RequestBody JobQuery query) {
		Job job = mapper.queryToJob(query);
		Page<Job> jobPage = service.find(job, page, size);
		return mapper.jobToResponse(jobPage);
	}

}
