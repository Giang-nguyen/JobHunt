package com.giang.jobhunt.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.giang.jobhunt.domain.FieldOfWork;
import com.giang.jobhunt.domain.Job;
import com.giang.jobhunt.domain.Job.Commitment;
import com.giang.jobhunt.domain.Job.Type;
import com.google.common.collect.Iterables;

@RunWith(SpringRunner.class)
@DataJpaTest
public class JobPredicateTest {
	
	@Autowired JobRepository repository;
	private static final String TITLE = "Software Engineer";
	private static final String EMPLOYER = "Microsoft";
	private static final Type TYPE = Type.PERMINENT;
	private static final Commitment COMMITMENT = Commitment.FULLTIME;
	private static final FieldOfWork FIELD = new FieldOfWork().name("engineer");
	private long numOfJob = 0;
	
	@Before
	public void setUp() {
		Job job = getFakeJob();
		repository.save(job);
		++numOfJob;
		job = getFakeJob().type(Type.INTERN);
		repository.save(job);
		++numOfJob;
		job = getFakeJob().commitment(Commitment.PARTTIME);
				repository.save(job);
				++numOfJob;
				job = getFakeJob().type(Type.INTERN).commitment(Commitment.PARTTIME);
				repository.save(job);
				++numOfJob;
	}
	
	@Test
	public void repositoryReturnAllJobWithEmptyOrNullPredicate() {
		Job query = null;
		Iterable<Job> jobs = repository.findAll(JobPredicate.getSearchCondition(query));
assertEquals(numOfJob, Iterables.size(jobs));
query = new Job();
jobs = repository.findAll(JobPredicate.getSearchCondition(query));
assertEquals(numOfJob, Iterables.size(jobs));
}
	
	@Test
	public void repositoryReturnCorrectJobsBasedOnQuery() {
		Job query = getFakeJob();
		
		Iterable<Job> jobs = repository.findAll(JobPredicate.getSearchCondition(query));
		assertEquals(Iterables.size(jobs), 1);
		
		query.commitment(null);
		jobs = repository.findAll(JobPredicate.getSearchCondition(query));
		assertNotEquals(1,  Iterables.size(jobs));
		assertNotEquals(numOfJob,  Iterables.size(jobs));
		jobs.forEach( job -> {
			assertEquals(query.title(), job.title());
			assertEquals(query.employer(), job.employer());
			assertEquals(query.fieldOfWork(), job.fieldOfWork());
			assertEquals(query.type(), job.type());
		});
		
		query.commitment(COMMITMENT);
		query.type(null);
		jobs = repository.findAll(JobPredicate.getSearchCondition(query));
		assertNotEquals(1,  Iterables.size(jobs));
		assertNotEquals(numOfJob,  Iterables.size(jobs));
		jobs.forEach( job -> {
			assertEquals(query.title(), job.title());
			assertEquals(query.employer(), job.employer());
			assertEquals(query.fieldOfWork(), job.fieldOfWork());
			assertEquals(query.commitment(), job.commitment());
		});
		
		query.commitment(null);
		query.type(null);
		jobs = repository.findAll(JobPredicate.getSearchCondition(query));
		assertEquals(numOfJob, Iterables.size(jobs));
		jobs.forEach( job -> {
			assertEquals(query.title(), job.title());
			assertEquals(query.employer(), job.employer());
			assertEquals(query.fieldOfWork(), job.fieldOfWork());
		});
		}
		
	private Job getFakeJob() {
		return new Job()
				.title(TITLE)
		.employer(EMPLOYER)
		.type(TYPE)
		.commitment(COMMITMENT)
		.fieldOfWork(FIELD);
	}
	
	}
