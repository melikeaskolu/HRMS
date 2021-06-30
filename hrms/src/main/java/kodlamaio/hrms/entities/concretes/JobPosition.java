package kodlamaio.hrms.entities.concretes;
import java.util.List;


import javax.persistence.Column;


import javax.persistence.Entity;

import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@Data
@EqualsAndHashCode(callSuper=false)
@Entity
@NoArgsConstructor 
@Table(name="job_positions")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "jobPostings"})
public class JobPosition extends Base {

	@Column(name="title")
	@NotBlank(message="Title Field cannot be Empty") //Başlık Alan Boş olamaz
	private String title;
	
	@OneToMany(mappedBy = "jobPosition")
	private List<JobPosting> jobPostings;
	
	public JobPosition(String title, List<JobPosting> jobPostings) {
		super();
		this.title = title;
		this.jobPostings = jobPostings;
	} 


	
}
