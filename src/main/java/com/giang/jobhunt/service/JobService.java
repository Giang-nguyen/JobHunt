package com.giang.jobhunt.service;

import java.util.List;
import org.springframework.data.domain.Page;

import com.giang.jobhunt.domain.Job;

public interface JobService {
	Job find(Long id);
	Page<Job> find(Job job, int page, int size);
	List<Job> find(Job job);
	void save(Job job);
	void update(Job job);
	void saveAll(List<Job> jobs);
	void updateAll(List<Job> jobs);
	void delete(Job job);
	void delete(Long id);

}
