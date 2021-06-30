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
@Table(name="cv_schools")
public class CvSchool extends Base {
	
	@Column(name= "school_name")
	@NotBlank(message="Cannot be Empty") //Boş olamaz
	private String schoolName;
	
	@Column(name= "department")
	@NotBlank(message="Cannot be Empty") //Boş olamaz
	private String department;
	
	@Column(name= "start_school")
	private LocalDate startSchool;
	
	@Column(name= "end_school", nullable = true)
	private LocalDate endSchool;
	
	@ManyToOne()
	@JoinColumn(name = "candidate_id")
	private Candidate candidate;
	
	

	
	
	
	
	

}
