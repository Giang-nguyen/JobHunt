package com.giang.jobhunt.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

@Data
@Accessors(fluent = true)
@EqualsAndHashCode
@ToString
@AllArgsConstructor
public class JobResponse implements Serializable {

	private static final long serialVersionUID = -3911222559584049561L;
	private String title;
	private String employer;
	private String type;
	private String commitment;
	private String createdDate;
	private String status;

}
