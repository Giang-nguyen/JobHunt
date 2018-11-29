package com.giang.jobhunt.dto;

import java.io.Serializable;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode
@ToString
@AllArgsConstructor
public class JobDetail implements Serializable {

	private static final long serialVersionUID = 8720339855624165460L;
	private String title;
	private String description;
	private String responsibility;
	private String requirement;
	private String employer;
	private String type;
	private String commitment;
	private String createdDate;
	private String availableDate;
	private String fieldOfWork;
	private Set<String> skills;
	private String status;

}
