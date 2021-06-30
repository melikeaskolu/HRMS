package kodlamaio.hrms.entities.concretes;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper=false)
@Entity
@AllArgsConstructor
@NoArgsConstructor 
@Table(name="cv_job_experiences")
public class CvJobExperience extends Base{

	@Column(name= "working_place_name")
	@NotBlank(message="working Place Name Cannot Be Blank") //Çalışma Yeri Adı Boş Geçilemez
	private String workingPlaceName;
	
	
	@Column(name= "position")
	private String position;
	
	@Column(name= "start_date")
	private LocalDate startDate;
	
	@Column(name= "end_date" , nullable = true)
	private LocalDate endDate;
	
	@ManyToOne()
	@JoinColumn(name = "candidate_id")
	private Candidate candidate;
	
	
	


}
