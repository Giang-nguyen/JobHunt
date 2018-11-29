package com.giang.jobhunt.repository;

import com.giang.jobhunt.domain.Job;
import com.giang.jobhunt.domain.QJob;
import com.querydsl.core.types.Predicate;

public final class JobPredicate {
	private JobPredicate() {
	}

	public static Predicate getSearchCondition(Job filter) {
		QJob job = QJob.job;
		if (filter == null)
			return job.isNotNull();
		else
			return job.isNotNull()
				.and(filter.title() != null? job.title.containsIgnoreCase(filter.title()) : null)
		.and(filter.employer() != null? job.employer.containsIgnoreCase(filter.employer()) : null)
		.and(filter.commitment() != null ? job.commitment.eq(filter.commitment()) : null)
		.and(filter.fieldOfWork() != null ? job.fieldOfWork.eq(filter.fieldOfWork()) : null)
		.and(filter.type() != null ? job.type.eq(filter.type()) : null);
	}
}
