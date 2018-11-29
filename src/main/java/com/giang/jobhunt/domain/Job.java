package com.giang.jobhunt.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

@Entity
@Data
@Accessors(fluent = true)
@EqualsAndHashCode
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Job implements Serializable {

	private static final long serialVersionUID = -7104960236001817937L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String title;
	private String description;
	private String responsibility;
	private String requirement;
	private String employer;
	@Enumerated(EnumType.STRING)
	private Type type;
	@Enumerated(EnumType.STRING)
	private Commitment commitment;
	private LocalDate createdDate;
	private LocalDate availableDate;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "fieldOfWorkId")
	private FieldOfWork fieldOfWork;
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "job_skill", joinColumns = @JoinColumn(name = "jobId", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "skillId", referencedColumnName = "id"))
	private Set<Skill> skills;
	@Enumerated(EnumType.STRING)
	private Status status;
	private LocalDateTime modifiedDate;

	public static enum Type {
		CONTRACT, PERMINENT, INTERN
	}

	public static enum Status {
		OPENING, REOPENED, CLOSED
	}

	public static enum Commitment {
		FULLTIME, PARTTIME, SHIFT
	}
}
