package com.giang.jobhunt.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode
@ToString
@AllArgsConstructor
public class JobQuery implements Serializable {

	private static final long serialVersionUID = -2962301868256998699L;
	private String title;
	private String employer;
	private String type;
	private String commitment;
	private String fieldOfWork;

}
