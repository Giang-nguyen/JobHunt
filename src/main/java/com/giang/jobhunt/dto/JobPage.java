package com.giang.jobhunt.dto;

import java.io.Serializable;
import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@Accessors(fluent = true)
@EqualsAndHashCode
@ToString
public class JobPage implements Serializable {

	private static final long serialVersionUID = -5548396860483399719L;
	private List<JobResponse> jobs;
	private long total;

}
