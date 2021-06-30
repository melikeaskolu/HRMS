package kodlamaio.hrms.entities.concretes;

import java.util.Date;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper=false)
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="job_postings")
public class JobPosting extends Base{

	@Column(name="job_description")
	private String jobDescription;
	
	@Column(name="min_salary")
	private int min_salary;
	
	@Column(name="max_salary")
	private int max_salary;
	
	@Column(name="release_date")  
	private Date releaseDate;
	
	@Column(name="application_deadline")
	private Date applicationDeadline;

	@Column(name = "is_open")
	private boolean isOpen;

	@Column(name = "open_position_count")
	private int openPositionCount;
	
	

	@ManyToOne()
	@JoinColumn(name="employer_id")
	private Employer employer;
	
	@ManyToOne()
	@JoinColumn(name="job_position_id")
	private JobPosition jobPosition;
	
	@ManyToOne()
	@JoinColumn(name="city_id")
	private City city;
	
	
	
	

}
