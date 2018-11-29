package com.giang.jobhunt.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.giang.jobhunt.domain.Job;
import com.giang.jobhunt.exception.JobNotFoundException;
import com.giang.jobhunt.repository.JobPredicate;
import com.giang.jobhunt.repository.JobRepository;
import com.google.common.collect.Lists;

@Service
public class JobServiceImpl implements JobService {

	private final JobRepository repository;

	@Autowired
	public JobServiceImpl(JobRepository repository) {
		this.repository = repository;
	}

	@Override
	public Job find(Long id) {
		return repository.findById(id).orElseThrow(JobNotFoundException::new);
	}

	@Override
	public List<Job> find(Job job) {
		return Lists.newArrayList(repository.findAll(JobPredicate.getSearchCondition(job)));
	}

	@Override
	public Page<Job> find(Job job, int page, int size) {
		return repository.findAll(JobPredicate.getSearchCondition(job), PageRequest.of(page, size));
	}

	@Override
	public void save(Job job) {
		job.createdDate(LocalDate.now())
		.modifiedDate(LocalDateTime.now());
		repository.save(job);
	}

	@Override
	public void saveAll(List<Job> jobs) {
		jobs.forEach(job -> {
			job.createdDate(LocalDate.now())
			.modifiedDate(LocalDateTime.now());
		});
		repository.saveAll(jobs);
	}

	@Override
	public void update(Job job) {
		job.modifiedDate(LocalDateTime.now());
		repository.save(job);
	}

	@Override
	public void updateAll(List<Job> jobs) {
		jobs.forEach(job -> job.modifiedDate(LocalDateTime.now()));
		repository.saveAll(jobs);
	}

	@Override
	public void delete(Job job) {
		repository.delete(job);
	}

	@Override
	public void delete(Long id) {
		repository.deleteById(id);
	}

}
